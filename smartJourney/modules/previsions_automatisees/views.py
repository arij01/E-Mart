from django.shortcuts import render,redirect
from .models import Prediction
from django.shortcuts import render, get_object_or_404
from .models import UserData, Prediction
from .forms import PredictionForm
from django.core.paginator import Paginator




def list_all_predictions(request):
    predictions_list = Prediction.objects.all().order_by('-created_at') 
    paginator = Paginator(predictions_list, 5)
    
    page_number = request.GET.get('page')
    predictions = paginator.get_page(page_number)
    
    return render(request, 'list_all_predictions.html', {'predictions': predictions})

def add_prediction(request):
    if request.method == 'POST':
        form = PredictionForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('list_all_predictions')  # Redirect to the list after adding
    else:
        form = PredictionForm()
    return render(request, 'form_prediction.html', {'form': form})

def edit_prediction(request, prediction_id):
    prediction = get_object_or_404(Prediction, id=prediction_id)
    if request.method == 'POST':
        form = PredictionForm(request.POST, instance=prediction)
        if form.is_valid():
            form.save()
            return redirect('list_all_predictions')  # Redirect to the list after editing
    else:
        form = PredictionForm(instance=prediction)
    return render(request, 'form_prediction.html', {'form': form, 'is_edit': True, 'prediction': prediction})

def delete_prediction(request, prediction_id):
    prediction = get_object_or_404(Prediction, id=prediction_id)
    prediction.delete()
    return redirect('list_all_predictions')

def view_prediction(request, prediction_id):
    prediction = get_object_or_404(Prediction, id=prediction_id)
    form = PredictionForm(instance=prediction)  # Load the form with existing prediction data
    return render(request, 'form_prediction.html', {'form': form, 'is_view': True})

