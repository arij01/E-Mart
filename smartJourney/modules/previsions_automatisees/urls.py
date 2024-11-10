from django.urls import path
from . import views

urlpatterns = [
    
        path('all/', views.list_all_predictions, name='list_all_predictions'),
        path('', views.list_all_predictions, name='list_all_predictions'),
        path('view/<int:prediction_id>/', views.view_prediction, name='view_prediction'),
        path('add/', views.add_prediction, name='add_prediction'),
        path('edit/<int:prediction_id>/', views.edit_prediction, name='edit_prediction'),
        path('delete/<int:prediction_id>/', views.delete_prediction, name='delete_prediction'),



]
