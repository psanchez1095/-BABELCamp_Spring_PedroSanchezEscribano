
--
-- Base de datos: `academia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `idAlumno` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `curso` varchar(45) DEFAULT NULL,
  `nota` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumno`, `nombre`, `curso`, `nota`) VALUES
(1, 'prueba', 'Java', 7),
(2, 'profe', 'Java', 8),
(3, 'alumno vip', 'Python', 6),
(4, 'nuevo', 'Java', 6),
(5, 'otro', 'Java', 7),
(6, 'tomates', 'Python', 6),
(7, 'pinpo', 'asd', 5),
(8, 'silla', 'Python', 9),
(10, 'principal', 'Java', 0),
(11, 'printer', 'Python', 8),
(12, 'microservicio', 'Spring', 0),
(13, 'microservicio2', 'Spring2', 7),
(14, 'JWT', 'Java', 9);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
