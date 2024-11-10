from django.shortcuts import render,redirect
from django.shortcuts import render, get_object_or_404
from .models import Activite
from .forms import ActiviteForm
from django.views.decorators.http import require_POST
from django.db.models import Q
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import json
from .analysis_sentiment import analyze_text

from django.core.paginator import Paginator






def list_all_activites(request):
    query = request.GET.get('search')
    if query:
        activites = Activite.objects.filter(Q(titre__icontains=query))
    else:
        activites = Activite.objects.all()
    
    paginator = Paginator(activites, 2)  # 2 activités par page
    page_number = request.GET.get('page')  # Numéro de la page à afficher
    page_obj = paginator.get_page(page_number)  # Obtenez la page courante

    return render(request, 'list_all_activites.html', {'page_obj': page_obj, 'query': query})
    #return render(request, 'list_all_activites.html', {'activites': activites})

def add_activite(request):
    if request.method == 'POST':
        form = ActiviteForm(request.POST, request.FILES)  # Assurez-vous d'inclure request.FILES pour les fichiers
        if form.is_valid():
            form.save()
            return redirect('list_all_activites')  # Redirigez vers la liste après ajout
    else:
        form = ActiviteForm()
    return render(request, 'form_activites.html', {'form': form})
def edit_activite(request, id):
    activite = get_object_or_404(Activite, id=id)
    if request.method == 'POST':
        form = ActiviteForm(request.POST, request.FILES, instance=activite)  # Inclure request.FILES ici
        if form.is_valid():
            form.save()
            return redirect('list_all_activites')  # Redirection vers la liste après modification
    else:
        form = ActiviteForm(instance=activite)
    return render(request, 'edit_activite.html', {'form': form, 'is_edit': True, 'activite': activite})


def delete_activite(request, id):
    activite = get_object_or_404(Activite, id=id)
    if request.method == 'POST':
        activite.delete()
        return redirect('list_all_activites')
    return redirect('list_all_activites') 



def front_activite(request):
    activites = Activite.objects.all()
    return render(request, 'front_activite.html', {'activites': activites})

def analyse_activite(request):
    activites = Activite.objects.all()
    return render(request, 'analyse_activite.html', {'activites': activites})


@csrf_exempt
def analyze_sentiment(request):
    if request.method == 'POST':
        try:
            text = request.POST.get('text', '')  # Obtenez le texte du formulaire
            if text:
                sentiment_result = analyze_text(text)  # Appelle la fonction d’analyse
                return JsonResponse({'sentiment': sentiment_result}, status=200)
            else:
                return JsonResponse({'error': 'No text provided'}, status=400)
        except Exception as e:
            return JsonResponse({'error': str(e)}, status=500)
    return JsonResponse({'error': 'Invalid request method'}, status=405)
# def analyze_sentiment(request):
#     if request.method == 'POST':
#         try:
#             # Utilisez request.POST pour extraire les données du formulaire
#             text = request.POST.get('text', '')  # Obtenez le texte du formulaire
#             if text:
#                 sentiment = analyze_text(text)  # Appelle la fonction d'analyse
#                 return JsonResponse({'sentiment': sentiment}, status=200)
#             else:
#                 return JsonResponse({'error': 'No text provided'}, status=400)
#         except Exception as e:
#             return JsonResponse({'error': str(e)}, status=500)
#     return JsonResponse({'error': 'Invalid request method'}, status=405)