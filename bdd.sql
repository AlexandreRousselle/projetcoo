drop table coo_joueur_partie;
drop table coo_partie_carte;
drop table coo_unite;
drop table coo_partie;
drop table coo_case;
drop table coo_joueur;
drop table coo_carte;

create table coo_joueur (
  id_joueur number(5),
  pseudo varchar(50),
  mdp varchar(50)
);

ALTER TABLE coo_joueur ADD CONSTRAINT PK_coo_joueur PRIMARY KEY (id_joueur);

create table coo_partie (
  id_partie number(5),
  nom_partie varchar(50),
  date_creation date,
  createur number(5),
  nb_joueurs number(5),
  nb_tours number(5),
  nb_ressources_initial number(10),
  nb_ressources_tour number(10),
  etat_partie varchar(50)
);

ALTER TABLE coo_partie ADD CONSTRAINT PK_coo_partie PRIMARY KEY (id_partie);
ALTER TABLE coo_partie ADD CONSTRAINT FK1_coo_partie FOREIGN KEY (createur) REFERENCES coo_joueur(id_joueur);

create table coo_carte (
  id_carte number(5),
  type_carte varchar(50),
  dimension_carte number(5)
);

ALTER TABLE coo_carte ADD CONSTRAINT PK_coo_carte PRIMARY KEY (id_carte);

create table coo_joueur_partie (
  id_joueur number(5),
  id_partie number(5),
  nb_ressources_actuels integer
);

ALTER TABLE coo_joueur_partie ADD CONSTRAINT PK_coo_joueur_partie PRIMARY KEY (id_joueur, id_partie);
ALTER TABLE coo_joueur_partie ADD CONSTRAINT FK1_coo_joueur_partie FOREIGN KEY (id_joueur) REFERENCES coo_joueur(id_joueur);
ALTER TABLE coo_joueur_partie ADD CONSTRAINT FK2_coo_joueur_partie FOREIGN KEY (id_partie) REFERENCES coo_partie(id_partie);

create table coo_partie_carte (
  id_partie number(5),
  id_carte number(5)
);

ALTER TABLE coo_partie_carte ADD CONSTRAINT PK_coo_partie_carte PRIMARY KEY (id_partie, id_carte);
ALTER TABLE coo_partie_carte ADD CONSTRAINT FK1_coo_partie_carte FOREIGN KEY (id_partie) REFERENCES coo_partie(id_partie);
ALTER TABLE coo_partie_carte ADD CONSTRAINT FK2_coo_partie_carte FOREIGN KEY (id_carte) REFERENCES coo_carte(id_carte);

create table coo_case (
  id_case number(10),
  id_carte number(5),
  posX number(10),
  posY number(10),
  build_on char(1 byte),
  type_case varchar(50),
  effet_case varchar(50),
  CONSTRAINT check_build_on CHECK (build_on IN (0, 1))
);

ALTER TABLE coo_case ADD CONSTRAINT PK_coo_case PRIMARY KEY (id_case);
ALTER TABLE coo_case ADD CONSTRAINT FK1_coo_case FOREIGN KEY (id_carte) REFERENCES coo_carte(id_carte);

create table coo_unite (
  id_unite number(5),
  id_joueur number(5),
  id_case number(10),
  type_unite varchar(50)
);

ALTER TABLE coo_unite ADD CONSTRAINT PK_coo_unite PRIMARY KEY (id_unite);
ALTER TABLE coo_unite ADD CONSTRAINT FK1_coo_unite FOREIGN KEY (id_joueur) REFERENCES coo_joueur(id_joueur);
ALTER TABLE coo_unite ADD CONSTRAINT FK2_coo_unite FOREIGN KEY (id_case) REFERENCES coo_case(id_case);

insert into coo_joueur values (1,'rousselle', 'rousselle');
insert into coo_joueur values (2,'cherifi', 'cherifi');

commit;
