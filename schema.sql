DROP TABLE IF EXISTS User_Newsgroup;
DROP TABLE IF EXISTS Newsgroup;
DROP TABLE IF EXISTS User;

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

INSERT INTO Newsgroup (name, display_name, description) VALUES
    ('redbrick.babble', 'Babble', 'Yack yack yack'),
    ('redbrick.announce', 'Announce', 'Society Announcements'),
    ('redbrick.things.we.hate', 'Things we hate', 'Hated things'),
    ('redbrick.things.we.love', 'Things we love', 'Loved things'),
    ('redbrick.humour.tasteless', 'Tasteless', 'The only sort of humour');
