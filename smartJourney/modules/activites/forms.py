from django import forms
from .models import Activite

class ActiviteForm(forms.ModelForm):
    class Meta:
        model = Activite
        fields = ['titre', 'description','date','image']
        widgets = {
            'description': forms.Textarea(attrs={'placeholder': 'Enter description here...'}),
            'date': forms.DateInput(attrs={'type': 'date', 'class': 'form-control text-dark'}),
        }

        