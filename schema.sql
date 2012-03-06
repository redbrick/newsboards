CREATE TABLE User (
    id int not null auto_increment,
    username varchar(255) not null,
    display_name varchar(255) not null,
    primary key(id)
) ENGINE=InnoDB;

CREATE TABLE Newsgroup (
    id int not null auto_increment,
    name varchar(1024) not null,
    display_name varchar(255) null,
    description varchar(255) null,
    primary key(id)
) ENGINE=InnoDB;

CREATE TABLE User_Newsgroup (
    user_id int not null,
    newsgroup_id int not null,
    foreign key (user_id) references User(id),
    foreign key (newsgroup_id) references Newsgroup(id)
) ENGINE=InnoDB;
