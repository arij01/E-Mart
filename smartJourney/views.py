from django.shortcuts import render
from django.contrib.auth.views import LoginView
from django.contrib import messages
from django.urls import reverse_lazy
from django.contrib.auth.decorators import login_required




def index(request):
    return render(request, 'front/base.frontend.html')

def home(request):
    return render(request, 'front/home.html')

@login_required(login_url='/login/')
def dashboard(request):
    return render(request, 'back/dashboard.html')

class CustomLoginView(LoginView):
    template_name = 'login.html'  # Path to your custom login template
    redirect_authenticated_user = True  # Redirect authenticated users
    success_url = reverse_lazy('admin:index')  # Redirect to admin dashboard after successful login

    def form_invalid(self, form):
        if self.request.method == "POST":  # Only show the message if the form was submitted
            messages.error(self.request, "Invalid username or password. Please try again.")
        return super().form_invalid(form)
