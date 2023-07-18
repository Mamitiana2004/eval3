\c postgres
drop database clinique;
create database clinique;
\c clinique

create table admin(
    id serial primary key,
    identifiant varchar(255),
    password text
);

insert into admin(identifiant,password) values ('admin','21232f297a57a5a743894a0e4a801fc3');

create table utilisateur(
    id serial primary key,
    identifiant varchar(255),
    password text
);

insert into utilisateur(identifiant,password) values ('Faneva','1a1dc91c907325c69271ddf0c944bc72');

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
    type varchar(255),
    budget numeric(16,2),
    code char(3)
);

insert into type_acte(type,budget,code)
values
    ('Consultation',30000000,'CON'),
    ('Operation',3000000,'OPE'),
    ('Analyse',4596000,'ANA');

create table type_depense(
    id serial primary key,
    libelle varchar(255),
    budget numeric(16,2),
    code char(3)
);

insert into type_depense(libelle,budget,code)
values
    ('Loyer',18000000,'LOY'),
    ('Reparation',2400000,'REP'),
    ('Salaire',4200000,'SAL');


create table acte(
    id serial primary key,
    type_acte int references type_acte(id) ON DELETE CASCADE,
    patient int references patient(id) ON DELETE CASCADE,
    prix int,
    dateActe date,
    valide boolean
);




create view v_acte as
select acte.id,type_acte.id as idType,type_acte.type,patient.id as idPatient,patient.nom,prix,dateActe,valide
from acte left join type_acte on type_acte.id=acte.type_acte
left join patient on patient.id=acte.patient;




create table depense(
    id serial primary key,
    type int references type_depense(id) ON DELETE CASCADE,
    prix int,
    dateDepense date
);  


create table mois(
    id serial primary key,
    mois varchar(20)
);

INSERT INTO mois (mois) VALUES
    ('Janvier'),
    ('Fevrier'),
    ('Mars'),
    ('Avril'),
    ('Mai'),
    ('Juin'),
    ('Juillet'),
    ('Aout'),
    ('Septembre'),
    ('Octobre'),
    ('Novembre'),
    ('Decembre');


create view v_depense as
select depense.id,type_depense.id as idType,type_depense.libelle,prix,dateDepense from depense left join type_depense on type_depense.id=depense.type;






create view recette_mois as
SELECT
    mois.id as idMois,
    mois.mois AS mois,
    date_part('year', acte.dateActe) AS annee,
    type_acte.id as idType,
    type_acte.type AS type_acte,
    SUM(acte.prix) AS recette
FROM
    acte
    INNER JOIN type_acte ON acte.type_acte = type_acte.id
    INNER JOIN mois ON date_part('month', acte.dateActe) = mois.id
GROUP BY
    mois.id,
    mois.mois,
    date_part('year', acte.dateActe),
    type_acte.id,
    type_acte.type,
    type_acte.budget;



create view depense_mois as
SELECT
    mois.id as idMois,
    mois.mois AS mois,
    date_part('year', depense.dateDepense) AS annee,
    type_depense.id as idType,
    type_depense.libelle AS type_acte,
    SUM(depense.prix) AS depense
FROM
    depense
    INNER JOIN type_depense ON depense.type = type_depense.id
    INNER JOIN mois ON date_part('month', depense.dateDepense) = mois.id
GROUP BY
    mois.id,
    mois.mois,
    date_part('year', depense.dateDepense),
    type_depense.id,
    type_depense.libelle,
    type_depense.budget;








