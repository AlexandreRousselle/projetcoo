create table coo_user (
  id_user number(5),
  pseudo varchar(50),
  mdp varchar(50)
);

ALTER TABLE coo_user ADD CONSTRAINT PK_COO_USER PRIMARY KEY (ID_USER);

create table coo_partie (
  id_partie number(5),
  nom_partie varchar(50),
  date_creation date,
  id_user number(5),
  nb_joueurs number(5),
  nb_tours number(5),
  nb_ressources_tour number(5),
  etat_partie varchar(50)
);

ALTER TABLE coo_partie ADD CONSTRAINT PK_coo_partie PRIMARY KEY (id_partie);
ALTER TABLE coo_partie ADD CONSTRAINT FK1_coo_partie FOREIGN KEY (id_user) REFERENCES coo_user(id_user);

create table coo_carte (
  id_carte number(5),
  type_carte varchar(50),
  dimension_carte number(5)
);

ALTER TABLE coo_carte ADD CONSTRAINT PK_coo_carte PRIMARY KEY (id_carte);

create table coo_partie_carte (
  id_partie number(5),
  id_carte number(5)
);

ALTER TABLE coo_partie_carte ADD CONSTRAINT PK_coo_partie_carte PRIMARY KEY (id_partie, id_carte);
ALTER TABLE coo_partie_carte ADD CONSTRAINT FK1_coo_partie_carte FOREIGN KEY (id_partie) REFERENCES coo_partie(id_partie);
ALTER TABLE coo_partie_carte ADD CONSTRAINT FK2_coo_partie_carte FOREIGN KEY (id_carte) REFERENCES coo_carte(id_carte);

create table coo_joueur (
  id_joueur number(5),
  nom_joueur varchar(50),
  tribu varchar(50),
  couleur varchar(50),
  ressources integer,
  id_partie number(5),
  id_user number(5)
);

ALTER TABLE coo_joueur ADD CONSTRAINT PK_coo_joueur PRIMARY KEY (id_joueur);
ALTER TABLE coo_joueur ADD CONSTRAINT FK1_coo_joueur FOREIGN KEY (id_partie) REFERENCES coo_partie(id_partie);
ALTER TABLE coo_joueur ADD CONSTRAINT FK2_coo_joueur FOREIGN KEY (id_user) REFERENCES coo_user(id_user);

insert into coo_user values (1,'rousselle','rousselle');

drop table coo_case;

create table coo_case (
  id_case number(10),
  posX number(10),
  posY number(10),
  build_on CHAR(1 byte),
  type_case varchar(50),
  effet_case varchar(50),
  id_carte number(5)
);

ALTER TABLE coo_case ADD CONSTRAINT PK_coo_case PRIMARY KEY (id_case);
ALTER TABLE coo_case ADD CONSTRAINT FK1_coo_case FOREIGN KEY (id_carte) REFERENCES coo_carte(id_carte);

commit;
