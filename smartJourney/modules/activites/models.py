from django.db import models

class Activite(models.Model):
    titre = models.CharField(max_length=100)         # Champ pour le titre de l'activité
    description = models.TextField()                  # Champ pour une description plus longue
    date = models.DateTimeField()                     # Champ pour la date de l'activité
    image = models.ImageField(upload_to='images/')

    def __str__(self):
        return self.titre
# Create your models here.
