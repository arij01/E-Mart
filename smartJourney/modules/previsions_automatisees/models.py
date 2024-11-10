from django.db import models
from django.contrib.auth.models import User

class UserData(models.Model):
    user_id = models.IntegerField()
    preferences = models.JSONField()
    history = models.TextField()

class Prediction(models.Model):
    user = models.ForeignKey(UserData, on_delete=models.CASCADE)
    prediction_text = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class UserData(models.Model):
    user_id = models.IntegerField()  # Assuming each user has a unique ID
    preferences = models.JSONField()  # Storing user preferences in JSON format
    history = models.TextField()  # Historical data or actions the user has taken

    def __str__(self):
        return f"User {self.user_id}"


class Prediction(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE) 
    prediction_text = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Prediction for User {self.user.user_id}"
