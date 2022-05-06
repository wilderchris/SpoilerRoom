truncate movie cascade;
alter sequence movie_movie_id_seq restart;

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Jurassic Park', 1993,
'A pragmatic paleontologist touring an almost complete theme park on an island in Central America is tasked with protecting a couple of kids after a power failure causes the parks cloned dinosaurs to run loose.',
'PG-13', 'Action');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Speed Racer', 2008, 
'Young driver Speed Racer aspires to be champion of the racing world with the help of his family and his high-tech Mach 5 automobile.', 
'PG', 'Action');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Ghostbusters', 1984, 
'Three parapsychologists forced out of their university funding set up shop as a unique ghost removal service in New York City, attracting frightened yet skeptical customers.', 
'PG', 'Comedy');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'The Prestige', 2006, 
'After a tragic accident, two stage magicians in 1890s London engage in a battle to create the ultimate illusion while sacrificing everything they have to outwit each other.', 
'PG-13', 'Drama');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'The Cabin in the Woods', 2011, 
'Five friends go for a break at a remote cabin, where they get more than they bargained for, discovering the truth behind the cabin in the woods.', 
'R', 'Horror');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Interstellar', 2014, 
'A team of explorers travel through a wormhole in space in an attempt to ensure humanitys survival.', 
'PG-13', 'Sci-Fi');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'What About Bob', 1991, 
'A successful psychotherapist loses his mind after one of his most dependent patients, an obsessive-compulsive neurotic, tracks him down during his family vacation.', 
'PG', 'Comedy');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Stripes', 1981, 
'Two friends who are dissatisfied with their jobs decide to join the army for a bit of fun.', 
'R', 'Comedy');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Phenomenon', 1996, 
'An ordinary man sees a bright light descend from the sky, and discovers he now has super-intelligence and telekinesis.', 
'PG', 'Drama');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Star Wars', 1977, 
'Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empires world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.', 
'PG', 'Adventure');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Event Horizon', 1997, 
'A rescue crew investigates a spaceship that disappeared into a black hole and has now returned...with someone or something new on-board.', 
'R', 'Horror');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Independence Day', 1996, 
'The aliens are coming and their goal is to invade and destroy Earth. Fighting superior technology, mankinds best weapon is the will to survive.', 
'PG-13', 'Action');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Cars', 2006, 
'A hot-shot race-car named Lightning McQueen gets waylaid in Radiator Springs, where he finds the true meaning of friendship and family.', 
'G', 'Family');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Remember the Titans', 2000, 
'The true story of a newly appointed African-American coach and his high school team on their first season as a racially integrated unit.', 
'PG', 'Biography');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Skyfall', 2012, 
'James Bonds loyalty to M is tested when her past comes back to haunt her. When MI6 comes under attack, 007 must track down and destroy the threat, no matter how personal the cost.', 
'PG-13', 'Action');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Dunkirk', 2017, 
'Allied soldiers from Belgium, the British Commonwealth and Empire, and France are surrounded by the German Army and evacuated during a fierce battle in World War II.', 
'PG-13', 'Action');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Shrek 2', 2004, 
'Shrek and Fiona travel to the Kingdom of Far Far Away, where Fionas parents are King and Queen, to celebrate their marriage. When they arrive, they find they are not as welcome as they thought they would be.', 
'PG', 'Family');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'Toy Story', 1995, 
'A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boys room.', 
'G', 'Family');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'The Dark Knight', 2008, 
'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 
'PG-13', 'Action');

insert into movie(id, movie_name, movie_year, description, movie_rating, genre) 
values (default, 'The Big Short', 2015, 
'In 2006-2007 a group of investors bet against the US mortgage market. In their research, they discover how flawed and corrupt the market is.', 
'R', 'Biography');