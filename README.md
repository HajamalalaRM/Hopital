# Hopital

Application de gestion d’un hôpital

•	Gestion des patients
•	CRUD
•	Recherche multicritère
•	Gestion des lits et chambres
•	Tarif chambre par catégorie
•	Attribution de chambre
•	Validation d’attribution de chambre
•	Séjour de chaque patient
•	Paiement (peut être multiple)
•	Etat de paiement 
•	Disponibilité des lits et chambres
•	Gestion des personnes membres du corps médical
•	Génération des fiches de prestation 
•	Etat des prestations par patient, par chambre, par période

Règles de gestion :
•	Il y a 3 catégories de chambre, et le tarif est différent selon la catégorie
•	Catégorie A : 1 chambre comporte 1 lit
•	Catégorie B : 1 chambre comporte 2 lits
•	Catégorie C : 1 chambre comporte 4 lits
•	Une avance de 200 000Ar doit être payé par tous les patients au moment de son entrée à l’hôpital, et cette somme est défalquée sur la totalité de la facture à sa sortie
•	Les membres du corps médical est payé en fonction de son grade et par patient traité :
Grade	Taux par jour par patient traité (Ar)
Infirmier	20 000
Médecin généraliste	35 000
Médecin spécialiste	50 000
Professeur	70 000


