from django import forms
from .models import Prediction

class PredictionForm(forms.ModelForm):
    class Meta:
        model = Prediction
        fields = ['user', 'prediction_text']
        widgets = {
            'prediction_text': forms.Textarea(attrs={'placeholder': 'Enter prediction here...'}),
        }
