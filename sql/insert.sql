-- BEING Show
INSERT INTO Show (name, description, venue, address, imageFeaturedUrl, featured) VALUES ('Osheaga', 'Edgy festival.', 'Parc Jean-Drapeau', '1 Circuit Gilles Villeneuve, Montréal, QC', 'http://i.imgur.com/wKsqNa4.jpg', true),
  ('The Summer Slaughter Tour', 'Next level brutalness.', 'Les Foufounes Électriques', '87 Rue Sainte-Catherine Est, Montréal, QC', 'http://i.imgur.com/4U6u008.jpg', true);
-- END Show

-- BEGIN Artist
INSERT INTO Artist (name, biography) VALUES ('The Black Keys', 'The Black Keys is an American rock duo formed in Akron, Ohio in 2001. The group consists of Dan Auerbach (guitar, vocals) and Patrick Carney (drums). The duo began as an independent act, recording music in basements and self-producing their records, before they eventually emerged as one of the most popular garage rock artists during a second wave of the genre''s revival in the 2010s. The band''s raw blues rock sound draws heavily from Auerbach''s blues influences, including Junior Kimbrough, Howlin'' Wolf, and Robert Johnson.'),
  ('Snoop Dogg', 'Calvin Cordozar Broadus, Jr. (born October 20, 1971), known by his stage names Snoop Doggy Dogg, Snoop Dogg, and later Snoop Lion, is an American rapper, singer-songwriter, and actor. Snoop has sold over 30 million albums worldwide. His music career began in 1992 when he was discovered by Dr. Dre. He collaborated on Dre''s solo debut The Chronic (1992), and on the theme song to the feature film Deep Cover.'),
  ('Infant Annihilator', 'If there is a band who are showing us that deathcore isn’t down and out for the count yet, it’s Infant Annihilator.  Many of us metal heads make endless fun of this style, but a few bands out there are the reason this style became a thing: Despised Icon, The Red Chord (who by the way are releasing a new album sometime in 2013), Animosity – bands who mixed the technicality and brutality of death metal yet also brought the grit and beatdown groove of hardcore into it.');

INSERT INTO Show_Artist (s_id, a_id) VALUES (1, 1),
  (1, 2),
  (2, 2);
-- END Artist

-- BEGIN Representation
INSERT INTO Representation (price, moment)  VALUES (199.99, timestamp '2014-08-01 14:00:00'),
  (199.99, timestamp '2014-08-02 14:00:00'),
  (199.99, timestamp '2014-08-03 14:00:00'),
  (29.99, timestamp '2014-08-15 14:00:00');

INSERT INTO Show_Representation (s_id, r_id) VALUES (1, 1),
  (1, 2),
  (1, 3),
  (2, 4);
-- END Representation