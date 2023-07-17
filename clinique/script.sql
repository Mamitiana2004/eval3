create database clinique;
\c clinique

create table admin(
    id serial primary key,
    identifiant varchar(255),
    password text
);

insert into admin(identifiant,password) values ('admin','21232f297a57a5a743894a0e4a801fc3');



create table patient(
    id serial primary key,
    nom varchar(255),
    dateNaissance date,
    genre char(1),
    remboursement boolean
);

insert into patient(nom,dateNaissance,genre,remboursement)
values
    ('Andria','2004-01-06','m',false);



create table type_acte(
    id serial primary key,
    type varchar(255)
);

insert into type_acte(type)
values
    ('Consultation'),
    ('Operation'),
    ('Analyse');

create table acte(
    id serial primary key,
    type_acte int references type_acte(id) ON DELETE CASCADE,
    patient int references patient(id) ON DELETE CASCADE,
    prix int,
    dateActe date
);



insert into acte(type_acte,patient,prix,dateActe)
values
    (1,7,40000,'2023-07-17');



create view v_acte as
select acte.id,type_acte.id as idType,type_acte.type,patient.id as idPatient,patient.nom,prix,dateActe
from acte left join type_acte on type_acte.id=acte.type_acte
left join patient on patient.id=acte.patient;


create table depense(
    id serial primary key,
    libelle varchar(255),
    prix int,
    dateDepense date
);  


insert into depense(libelle,prix,dateDepense)
values
    ('Salaire',10000000,'2023-07-17');

create table utilisateur(
    id serial primary key,
    identifiant varchar(255),
    password text
);

insert into utilisateur(identifiant,password) values
    ('Jean','1a1dc91c907325c69271ddf0c944bc72');


create view budget as
SELECT 
    EXTRACT(MONTH FROM dateActe) AS mois,
    EXTRACT(YEAR FROM dateActe) AS annee,
    COALESCE(SUM(acte.prix), 0) AS recettes,
    COALESCE(SUM(depense.prix), 0) AS depenses,
    COALESCE(SUM(acte.prix), 0) - COALESCE(SUM(depense.prix), 0) AS budget
FROM acte
LEFT JOIN depense ON EXTRACT(MONTH FROM acte.dateActe) = EXTRACT(MONTH FROM depense.dateDepense)
GROUP BY mois, annee
ORDER BY annee, mois;

create view budget as   
WITH mois AS (
    SELECT generate_series(1, 12) AS mois
), annees AS (
    SELECT DISTINCT EXTRACT(YEAR FROM dateActe) AS annee FROM acte
)
SELECT
    mois.mois,
    annees.annee,
    COALESCE(SUM(acte.prix), 0) AS recettes,
    COALESCE(SUM(depense.prix), 0) AS depenses,
    COALESCE(SUM(acte.prix), 0) - COALESCE(SUM(depense.prix), 0) AS budget
FROM
    mois
CROSS JOIN annees
LEFT JOIN acte ON mois.mois = EXTRACT(MONTH FROM acte.dateActe) AND annees.annee = EXTRACT(YEAR FROM acte.dateActe)
LEFT JOIN depense ON mois.mois = EXTRACT(MONTH FROM depense.dateDepense) AND annees.annee = EXTRACT(YEAR FROM depense.dateDepense)
GROUP BY mois.mois, annees.annee
ORDER BY annees.annee, mois.mois;

