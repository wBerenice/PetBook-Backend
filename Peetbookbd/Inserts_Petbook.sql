-- administradores 
INSERT INTO `petbookbd`.`administradores` (`nombre`, `contraseña`) VALUES ('gama', 'gama1234');
INSERT INTO `petbookbd`.`administradores` (`nombre`, `contraseña`) VALUES ('bere', 'bere1234');
INSERT INTO `petbookbd`.`administradores` (`nombre`, `contraseña`) VALUES ('josue', 'josue1234');
INSERT INTO `petbookbd`.`administradores` (`nombre`, `contraseña`) VALUES ('marco', 'marco1234');
INSERT INTO `petbookbd`.`administradores` (`nombre`, `contraseña`) VALUES ('abraham', 'abreham1234');
INSERT INTO `petbookbd`.`administradores` (`nombre`, `contraseña`) VALUES ('bianca', 'bianca1234');

-- usuarios
INSERT INTO `petbookbd`.`usuarios` (`nombre`, `correo`, `especie`, `telefono`, `contraseña`) VALUES ('gama', 'gama_sibaja@gmail.com', 'perro', '5584479575', 'gama1234');
INSERT INTO `petbookbd`.`usuarios` (`nombre`, `correo`, `especie`, `telefono`, `contraseña`) VALUES ('rufs', 'rufs@gmail.com', 'perro', '5521664585', 'rufs123');
INSERT INTO `petbookbd`.`usuarios` (`nombre`, `correo`, `especie`, `telefono`, `contraseña`) VALUES ('chilaquil', 'chilaquil@gmail.com', 'perro', '5563526352', 'chilaquil123');
INSERT INTO `petbookbd`.`usuarios` (`nombre`, `correo`, `especie`, `telefono`, `contraseña`) VALUES ('michi', 'michi@gmail.com', 'gato', '5548759575', 'gatita1515');
INSERT INTO `petbookbd`.`usuarios` (`nombre`, `correo`, `especie`, `telefono`, `contraseña`) VALUES ('rocky', 'rocky@gmail.com', 'perro', '5548759654', 'rocky619');

-- publicaciones 
INSERT INTO `petbookbd`.`publicaciones` (`titulo`, `descripcion`, `foto`, `likes`, `usuarios_idusuarios`) VALUES ('hola', 'les presento mi perfil en petbook ', 'foto.jpg', '0', '2');
INSERT INTO `petbookbd`.`publicaciones` (`titulo`, `descripcion`, `foto`, `likes`, `usuarios_idusuarios`) VALUES ('En el parque', 'foto en el parque con mi dueo ', 'parque.jpg', '0', '3');
INSERT INTO `petbookbd`.`publicaciones` (`titulo`, `descripcion`, `foto`, `likes`, `usuarios_idusuarios`) VALUES ('Juguete', 'les muestro la foto de mi nuevo juguete ', 'imagen_generica.jpg', '0', '2');
INSERT INTO `petbookbd`.`publicaciones` (`titulo`, `descripcion`, `foto`, `likes`, `usuarios_idusuarios`) VALUES ('Amigos', 'les recomiendo este paruqe para sus perritos ', '', '0', '1');
INSERT INTO `petbookbd`.`publicaciones` (`titulo`, `descripcion`, `foto`, `likes`, `usuarios_idusuarios`) VALUES ('Descanso ', 'foto durmiendo ', 'imagen123.jpg', '0', '4');

-- likes 
INSERT INTO `petbookbd`.`likes` (`publicaciones_id_publicacion`, `usuarios_idusuarios`) VALUES ('1', '2');
INSERT INTO `petbookbd`.`likes` (`publicaciones_id_publicacion`, `usuarios_idusuarios`) VALUES ('2', '3');
INSERT INTO `petbookbd`.`likes` (`publicaciones_id_publicacion`, `usuarios_idusuarios`) VALUES ('3', '2');
INSERT INTO `petbookbd`.`likes` (`publicaciones_id_publicacion`, `usuarios_idusuarios`) VALUES ('4', '1');
INSERT INTO `petbookbd`.`likes` (`publicaciones_id_publicacion`, `usuarios_idusuarios`) VALUES ('5', '4');
