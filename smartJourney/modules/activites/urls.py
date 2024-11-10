from django.conf import settings
from django.conf.urls.static import static
from django.urls import path
from . import views

urlpatterns = [
    
        path('all/', views.list_all_activites, name='list_all_activites'),
        #path('view/<int:prediction_id>/', views.view_prediction, name='view_prediction'),
        path('add/', views.add_activite, name='add_activite'),
        
        path('edit/<int:id>/', views.edit_activite, name='edit_activite'),
        path('delete_avis/<int:id>/', views.delete_activite, name='delete_activite'),
        path('avisFront/', views.front_activite, name='front_activite'),
        path('avisAnalyse/', views.analyse_activite, name='analyse_activite'),
        path('analyze-sentiment/', views.analyze_sentiment, name='analyze_sentiment')


]

# Ajouter ceci pour servir les fichiers médias pendant le développement
#if settings.DEBUG:  # Only add this when in DEBUG mode
    #urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)