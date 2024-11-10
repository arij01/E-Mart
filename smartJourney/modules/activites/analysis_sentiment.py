import os
import google.generativeai as genai

# Configurer la clé API
os.environ["GOOGLE_API_KEY"] = "AIzaSyA1OY3yFqle1sdG6vXToiG6XmkoF5peH6I"  # Remplacez par votre clé API
# Configurez l'API avec votre clé
genai.configure(api_key=os.environ.get("GOOGLE_API_KEY"))

def analyze_text(text):
    """Analyse le sentiment d'un texte donné."""
    generation_config = {
        "temperature": 0.5,
        "top_p": 0.95,
        "top_k": 64,
        "max_output_tokens": 8192,
        "response_mime_type": "text/plain",
    }

    model = genai.GenerativeModel(
        model_name="gemini-1.5-flash",
        generation_config=generation_config,
    )

    response = model.generate_content([
        "Tell me whether the following sentence's sentiment is positive or negative or something in between.",
        text,
        "Sentiment ",
    ])

    return response.text
if __name__ == "__main__":
    text_to_analyze = "Je suis très heureux aujourd'hui !"  # Exemple de texte
    print("Analyse du texte : ", text_to_analyze)  # Affichez le texte analysé
    try:
        sentiment = analyze_text(text_to_analyze)
        print(f"Sentiment: {sentiment}")  # Affichez le sentiment
    except Exception as e:
        print(f"Une erreur est survenue : {e}")