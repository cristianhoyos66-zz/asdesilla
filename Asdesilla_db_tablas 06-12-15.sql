DROP DATABASE IF EXISTS asdesilla_db;
CREATE DATABASE asdesilla_db;
USE asdesilla_db;
DROP TABLE IF EXISTS tbl_terapias_alternativas;
DROP TABLE IF EXISTS tbl_area_psicosocial;
DROP TABLE IF EXISTS tbl_fonoaudiologia;
DROP TABLE IF EXISTS tbl_fisioterapia;
DROP TABLE IF EXISTS tbl_evaluacion;
DROP TABLE IF EXISTS tbl_estudios_compl;
DROP TABLE IF EXISTS tbl_planeacion_terapeutica;
DROP TABLE IF EXISTS tbl_consentimientos;
DROP TABLE IF EXISTS tbl_forma_ensenanza;
DROP TABLE IF EXISTS tbl_autoridad;
DROP TABLE IF EXISTS tbl_terapias;
DROP TABLE IF EXISTS tbl_tipo_terapias;
DROP TABLE IF EXISTS tbl_historia_clinica;
DROP TABLE IF EXISTS tbl_acompanamiento;
DROP TABLE IF EXISTS tbl_tipo_remision;
DROP TABLE IF EXISTS tbl_pacientes;
DROP TABLE IF EXISTS tbl_familiares;
DROP TABLE IF EXISTS tbl_grupo_familiar;
DROP TABLE IF EXISTS tbl_caballos;
DROP TABLE IF EXISTS tbl_profesionales;
DROP TABLE IF EXISTS tbl_usuarios;
DROP TABLE IF EXISTS tbl_municipio;
DROP TABLE IF EXISTS tbl_departamento;
DROP TABLE IF EXISTS tbl_tipo_documentos;
DROP TABLE IF EXISTS tbl_cargo;
DROP TABLE IF EXISTS tbl_tipo_cargo;
DROP TABLE IF EXISTS tbl_horario_laboral_profesional;
DROP TABLE IF EXISTS tbl_generos;
DROP TABLE IF EXISTS tbl_eps;
DROP TABLE IF EXISTS tbl_estado_civil;
DROP TABLE IF EXISTS tbl_parentescos;
DROP TABLE IF EXISTS tbl_perfiles;

CREATE TABLE tbl_perfiles
(
IdPerfil int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_perfiles PRIMARY KEY (IdPerfil));

CREATE TABLE tbl_eps
(
IdEps int AUTO_INCREMENT,
Nombre varchar(50)NOT NULL,
CONSTRAINT PKtbl_eps PRIMARY KEY (IdEps));

CREATE TABLE tbl_tipo_documentos
(
IdTipoDoc int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_tipo_documentos PRIMARY KEY (IdTipoDoc));

CREATE TABLE tbl_generos
(
IdGenero int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_generos PRIMARY KEY (IdGenero));

CREATE TABLE tbl_estado_civil
(
IdEstCivil int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_estado_civil PRIMARY KEY (IdEstCivil));

CREATE TABLE tbl_parentescos
(
IdParentesco int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_parentescos PRIMARY KEY (IdParentesco));

CREATE TABLE tbl_autoridad
(
IdPAutoridad int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_autoridad PRIMARY KEY (IdPAutoridad));

CREATE TABLE tbl_departamento
(
iddepartamento int AUTO_INCREMENT,
nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_departamento PRIMARY KEY (iddepartamento));

CREATE TABLE tbl_municipio
(
idmunicipio int AUTO_INCREMENT,
nombreMunicipio varchar(30)NOT NULL,
departamento_iddepartamento int NOT NULL,
CONSTRAINT PKtbl_departamento PRIMARY KEY (idmunicipio),
CONSTRAINT FK_departamento_municipio FOREIGN KEY(departamento_iddepartamento)REFERENCES tbl_departamento(iddepartamento));

CREATE TABLE tbl_tipo_cargo
(
IdTipoCargo int AUTO_INCREMENT,
NombreTipoCargo varchar(30)NOT NULL,
CONSTRAINT PKtbl_tipo_cargo PRIMARY KEY (IdTipoCargo));

CREATE TABLE tbl_cargo
(
IdCargo int AUTO_INCREMENT,
NombreCargo varchar(30)NOT NULL,
TipoCargo int NOT NULL,
CONSTRAINT PKtbl_cargo PRIMARY KEY (IdCargo),
CONSTRAINT FK_TipoCargo_cargo FOREIGN KEY(TipoCargo)REFERENCES tbl_tipo_cargo(IdTipoCargo));

CREATE TABLE tbl_horario_laboral_profesional
(
IdHorarioLaboralPM int AUTO_INCREMENT,
NombreHorarioLaboralPM varchar(30)NOT NULL,
CONSTRAINT PKtbl_horario_laboral_profesional PRIMARY KEY (IdHorarioLaboralPM));

CREATE TABLE tbl_forma_ensenanza
(
IdFormaEnsenanza int AUTO_INCREMENT,
NombreFormaEnsenanza varchar(50)NOT NULL,
CONSTRAINT PKtbl_forma_ensenanza PRIMARY KEY (IdFormaEnsenanza));

CREATE TABLE tbl_tipo_remision
(
IdTipoRemision int AUTO_INCREMENT,
NombreTipoRemision varchar(30)NOT NULL,
CONSTRAINT PKtbl_tipo_remision PRIMARY KEY (IdTipoRemision));

CREATE TABLE tbl_usuarios
(
IdUsuario varchar(20)NOT NULL,
TipoId int NOT NULL,
Nombre varchar(30)NOT NULL,
Apellido1 varchar(30)NOT NULL,
Apellido2 varchar(30),
Cargo int NOT NULL,
Usuario varchar(15)NOT NULL,
Clave varchar(200)NOT NULL,
Cambio_clave int(1)NOT NULL DEFAULT 0,
Perfil int NOT NULL,
Estado varchar(20)NOT NULL,
CONSTRAINT PKtbl_usuarios PRIMARY KEY (Usuario),
CONSTRAINT FK_TipoId_usuarios FOREIGN KEY(TipoId)REFERENCES tbl_tipo_documentos(IdTipoDoc),
CONSTRAINT FK_Cargo_usuarios FOREIGN KEY(Cargo)REFERENCES tbl_cargo(IdCargo),
CONSTRAINT FK_Perfil_usuarios FOREIGN KEY(Perfil)REFERENCES tbl_perfiles(IdPerfil),
UNIQUE I_IdUsuario_usuarios(IdUsuario));

CREATE TABLE tbl_grupo_familiar
(
IdGrupoFamiliar int AUTO_INCREMENT,
NombreGrupoFamiliar varchar(50)NOT NULL,
CONSTRAINT PKtbl_grupo_familiar PRIMARY KEY (IdGrupoFamiliar));

CREATE TABLE tbl_familiares
(
IdFamiliar varchar(20)NOT NULL,
Parentesco int NOT NULL,
Nombre varchar(30),
Apellido1 varchar(30),
Apellido2 varchar(30),
FechaNacimiento varchar(20),
Eps int NOT NULL,
Telefono varchar(15)DEFAULT NULL,
Celular varchar(15)DEFAULT NULL,
Departamento int NOT NULL,
Municipio int NOT NULL,
Barrio varchar(30) NOT NULL,
Direccion varchar(30)NOT NULL,
GrupoFamiliar int NOT NULL,
Estado varchar(20)NOT NULL,
CONSTRAINT PKtbl_familiares PRIMARY KEY (IdFamiliar),
CONSTRAINT FK_Parentesco_familiares FOREIGN KEY(Parentesco)REFERENCES tbl_parentescos(IdParentesco),
CONSTRAINT FK_Departamento_familiares FOREIGN KEY(Departamento)REFERENCES tbl_departamento(iddepartamento),
CONSTRAINT FK_Municipio_familiares FOREIGN KEY(Municipio)REFERENCES tbl_municipio(idmunicipio),
CONSTRAINT FK_Eps_familiares FOREIGN KEY(Eps)REFERENCES tbl_eps(IdEps),
CONSTRAINT FK_GrupoFamiliar_familiares FOREIGN KEY(GrupoFamiliar)REFERENCES tbl_grupo_familiar(IdGrupoFamiliar));

CREATE TABLE tbl_pacientes
(
IdPaciente varchar(20)NOT NULL,
TipoId int NOT NULL,
LugarExpedicion varchar(15)NOT NULL,
Nombre varchar(30)NOT NULL,
Apellido1 varchar(30)NOT NULL,
Apellido2 varchar(30),
FechaNacimiento varchar(20)NOT NULL,
Genero int NOT NULL,
EstadoCivil int NOT NULL,
Departamento int NOT NULL,
Municipio int NOT NULL,
Barrio varchar(30) NOT NULL,
Direccion varchar(30)NOT NULL,
Telefono varchar(15)DEFAULT NULL,
Celular varchar(15)DEFAULT NULL,
Ocupacion varchar(30)NOT NULL,
Eps int NOT NULL,
AntPNatales varchar(1000) NOT NULL,
AntMed varchar(1000) NOT NULL,
AntFamiliares varchar(1000) NOT NULL,
AntQuirurgicos varchar(1000) NOT NULL,
OtrosAnt varchar(1000) NOT NULL,
TipoRemision int NOT NULL,
RemitidoPor varchar(30) NOT NULL,
Discapacidad varchar(20)NOT NULL,
Estado varchar(20)NOT NULL,
CONSTRAINT PKtbl_pacientes PRIMARY KEY (IdPaciente),
CONSTRAINT FK_TipoId_pacientes FOREIGN KEY(TipoId)REFERENCES tbl_tipo_documentos(IdTipoDoc),
CONSTRAINT FK_Eps_pacientes FOREIGN KEY(Eps)REFERENCES tbl_eps(IdEps),
CONSTRAINT FK_Genero_pacientes FOREIGN KEY(Genero)REFERENCES tbl_generos(IdGenero),
CONSTRAINT FK_Departamento_pacientes FOREIGN KEY(Departamento)REFERENCES tbl_departamento(iddepartamento),
CONSTRAINT FK_Municipio_pacientes FOREIGN KEY(Municipio)REFERENCES tbl_municipio(idmunicipio),
CONSTRAINT FK_EstadoCivil_pacientes FOREIGN KEY(EstadoCivil)REFERENCES tbl_estado_civil(IdEstCivil),
CONSTRAINT FK_TipoRemision_pacientes FOREIGN KEY(TipoRemision)REFERENCES tbl_tipo_remision(IdTipoRemision));

CREATE TABLE tbl_acompanamiento
(
IdPaciente varchar(20)NOT NULL,
IdFamiliar int NOT NULL,
CONSTRAINT PKtbl_acompanamiento PRIMARY KEY (IdPaciente, IdFamiliar),
CONSTRAINT FK_IdPaciente_acompanamiento FOREIGN KEY(IdPaciente)REFERENCES tbl_pacientes(IdPaciente),
CONSTRAINT FK_IdFamiliar_acompanamiento FOREIGN KEY(IdFamiliar)REFERENCES tbl_grupo_familiar(IdGrupoFamiliar));

CREATE TABLE tbl_historia_clinica
(
IdHistoriaClinica int AUTO_INCREMENT,
IdPaciente varchar(20)NOT NULL,
Estado varchar(20)NOT NULL,
CONSTRAINT PKtbl_historia_clinica PRIMARY KEY (IdHistoriaClinica),
CONSTRAINT FK_IdPaciente_historia_clinica FOREIGN KEY(IdPaciente)REFERENCES tbl_pacientes(IdPaciente),
UNIQUE I_IdPaciente_historia_clinica(IdPaciente));

CREATE TABLE tbl_planeacion_terapeutica
(
IdHistoriaClinica int NOT NULL,
FechaDiligencia varchar(20)NOT NULL,
FormaEnsenanza int NOT NULL,
Antecedentes varchar(500)NOT NULL,
ObjGeneral varchar(500)NOT NULL,
ObjEspecificos varchar(500)NOT NULL,
Estrategia varchar(500)NOT NULL,
MaterialDidactico varchar(500)NOT NULL,
Comentarios varchar(1000),
CONSTRAINT PKtbl_planeacion_terapeutica PRIMARY KEY (IdHistoriaClinica, FechaDiligencia),
CONSTRAINT FK_IdHistoriaClinica_planeacion_terapeutica FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_IdForma_ensenanza_planeacion_terapeutica FOREIGN KEY(FormaEnsenanza)REFERENCES tbl_forma_ensenanza(IdFormaEnsenanza));

CREATE TABLE tbl_profesionales
(
NumRegistro varchar(20)NOT NULL,
IdProfesional varchar(20)NOT NULL,
TipoId int NOT NULL,
Nombre varchar(30)NOT NULL,
Apellido1 varchar(30)NOT NULL,
Apellido2 varchar(30),
FechaNacimiento varchar(20)NOT NULL,
Genero int NOT NULL,
Departamento int NOT NULL,
Municipio int NOT NULL,
Barrio varchar(30) NOT NULL,
Direccion varchar(30)NOT NULL,
Telefono varchar(15)DEFAULT NULL,
Celular varchar(15)DEFAULT NULL,
Ocupacion int NOT NULL,
HorarioLaboral int NOT NULL,
Estado varchar(20)NOT NULL,
CONSTRAINT PKtbl_Profesionales PRIMARY KEY (NumRegistro),
CONSTRAINT FK_TipoId_profesionales FOREIGN KEY(TipoId)REFERENCES tbl_tipo_documentos(IdTipoDoc),
CONSTRAINT FK_Departamento_profesionales FOREIGN KEY(Departamento)REFERENCES tbl_departamento(iddepartamento),
CONSTRAINT FK_Municipio_profesionales FOREIGN KEY(Municipio)REFERENCES tbl_municipio(idmunicipio),
CONSTRAINT FK_Genero_profesionales FOREIGN KEY(Genero)REFERENCES tbl_generos(IdGenero),
CONSTRAINT FK_Ocupacion_profesionales FOREIGN KEY(Ocupacion)REFERENCES tbl_cargo(IdCargo),
CONSTRAINT FK_HorarioLaboral_profesionales FOREIGN KEY(HorarioLaboral)REFERENCES tbl_horario_laboral_profesional(IdHorarioLaboralPM),
UNIQUE I_IdProfesional_profesionales(IdProfesional));

CREATE TABLE tbl_consentimientos
(
IdHistoriaClinica int NOT NULL,
CodigoConsentimiento int AUTO_INCREMENT,
Fecha varchar(20) NOT NULL,
IdProfesional varchar(20) NOT NULL,
Adjunto longblob NOT NULL,
CONSTRAINT PKtbl_consentimientos PRIMARY KEY (CodigoConsentimiento),
CONSTRAINT FK_IdHistoriaClinica_consentimientos FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_IdProfesional_consentimientos FOREIGN KEY(IdProfesional)REFERENCES tbl_profesionales(NumRegistro));

CREATE TABLE tbl_caballos 
(
Nrege varchar(15)NOT NULL,
Nombre varchar(30)NOT NULL,
NombreDuenio varchar(30)NOT NULL,
Apellido1Duenio varchar(30)NOT NULL,
Apellido2Duenio varchar(30),
Edad varchar(15)NOT NULL,
Cria varchar(30)NOT NULL,
Anem varchar(30)NOT NULL,
Estado varchar(20)NOT NULL,
CONSTRAINT PKtbl_caballos PRIMARY KEY (Nrege));

CREATE TABLE tbl_tipo_terapias
(
IdTipoTerapia int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
CONSTRAINT PKtbl_tipo_terapias PRIMARY KEY (IdTipoTerapia));

CREATE TABLE tbl_terapias
(
IdTerapia int AUTO_INCREMENT,
Nombre varchar(30)NOT NULL,
Tipo int NOT NULL,
CONSTRAINT PKtbl_terapias PRIMARY KEY (IdTerapia),
CONSTRAINT FK_Tipo_terapias FOREIGN KEY(Tipo)REFERENCES tbl_tipo_terapias(IdTipoTerapia));

CREATE TABLE tbl_estudios_compl
(
IdHistoriaClinica int NOT NULL,
IdTerapia int NOT NULL,
CONSTRAINT PKtbl_estudios_compl PRIMARY KEY (IdHistoriaClinica, IdTerapia),
CONSTRAINT FK_IdHistoriaClinica_estudios_compl FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_IdTerapia_estudios_compl FOREIGN KEY(IdTerapia)REFERENCES tbl_terapias(IdTerapia));

CREATE TABLE tbl_evaluacion
(
IdHistoriaClinica int NOT NULL,
Fecha varchar(10)NOT NULL,
MotivoConsulta varchar(500)NOT NULL,
DiagMed varchar(500) NOT NULL,
TratMedActual varchar(500) NOT NULL,
Peso varchar(15) NOT NULL,
FC varchar(15) NOT NULL,
FR varchar(15) NOT NULL,
PA varchar(15) NOT NULL,
Talla varchar(15) NOT NULL,
IMC varchar(15) NOT NULL,
Profesional varchar(20) NOT NULL,
CONSTRAINT PKtbl_evaluacion PRIMARY KEY (IdHistoriaClinica, Fecha),
CONSTRAINT FK_IdHistoriaClinica_evaluacion FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_IdProfesional_evaluacion FOREIGN KEY(Profesional)REFERENCES tbl_profesionales(NumRegistro));

CREATE TABLE tbl_fisioterapia
(
IdHistoriaClinica int NOT NULL,
Fecha varchar(10)NOT NULL,
ControlCefalico varchar(15)NOT NULL,
Rolados varchar(15)NOT NULL,
Arrastre varchar(15)NOT NULL,
Gateo varchar(15)NOT NULL,
Sedestesacion varchar(15)NOT NULL,
Bipedestacion varchar(15)NOT NULL,
Marcha varchar(15)NOT NULL,
Apoyo varchar(15),
PartesCuerpo varchar(20)NOT NULL,
DPartesCuerpo varchar(500),
TonoMuscular varchar(20)NOT NULL,
Observaciones varchar(1000)NOT NULL,
Profesional varchar(20)NOT NULL,
CONSTRAINT PKtbl_fisioterapia PRIMARY KEY (IdHistoriaClinica, Fecha),
CONSTRAINT FK_IdHistoriaClinica_fisioterapia FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_IdProfesional_fisioterapia FOREIGN KEY(Profesional)REFERENCES tbl_profesionales(NumRegistro));

CREATE TABLE tbl_fonoaudiologia
(
IdHistoriaClinica int NOT NULL,
Fecha varchar(10)NOT NULL,
ActPrelinguisticas varchar(15)NOT NULL,
ActLinguisticas varchar(15)NOT NULL,
TipoLenguaje varchar(15)NOT NULL,
RespNombre varchar(15)NOT NULL,
ConoceNombre varchar(15)NOT NULL,
AlimentacionActual varchar(500),
Observaciones varchar(1000)NOT NULL,
ControlEsfinteres varchar(15)NOT NULL,
VesicalDiurno varchar(15),
VesicalNocturno varchar(15),
AnalDiurno varchar(15),
AnalNocturno varchar(15),
Profesional varchar(20)NOT NULL,
CONSTRAINT PKtbl_fonoaudiologia PRIMARY KEY (IdHistoriaClinica, Fecha),
CONSTRAINT FK_IdHistoriaClinica_fonoaudiologia FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_IdProfesional_fonoaudiologia FOREIGN KEY(Profesional)REFERENCES tbl_profesionales(NumRegistro));

CREATE TABLE tbl_area_psicosocial
(
IdHistoriaClinica int NOT NULL,
Fecha varchar(10)NOT NULL,
EntPadres varchar(15)NOT NULL, 
EntFamiliares varchar(15)NOT NULL, 
EntCompaneros varchar(15)NOT NULL, 
EntExtranos varchar(15)NOT NULL, 
PerMayorT varchar(30)NOT NULL, 
Fortalezas varchar(500)NOT NULL, 
Debilidades varchar(500)NOT NULL, 
ResptNorma varchar(15)NOT NULL, 
TransgNorma varchar(15)NOT NULL, 
ObdOrdenes varchar(15)NOT NULL, 
Autoridad int NOT NULL, 
ActPreferida varchar(30)NOT NULL, 
DiaCotidiano varchar(500)NOT NULL, 
Escolaridad varchar(15)NOT NULL, 
Horario varchar(15), 
Lugar varchar(30), 
FBanoCorp varchar(15)NOT NULL, 
FVestirse varchar(15)NOT NULL, 
FLavarse varchar(15)NOT NULL, 
FAlimentacion varchar(15)NOT NULL, 
FPeinarse varchar(15)NOT NULL, 
FAbotonarse varchar(15)NOT NULL, 
FDormir varchar(15)NOT NULL, 
FAmarrarse varchar(15)NOT NULL,  
Observaciones varchar(1000)NOT NULL,
Profesional varchar(20)NOT NULL,
CONSTRAINT PKtbl_area_psicosocial PRIMARY KEY (IdHistoriaClinica, Fecha),
CONSTRAINT FK_IdHistoriaClinica_area_psicosocial FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_Autoridad_area_psicosocial FOREIGN KEY(Autoridad)REFERENCES tbl_autoridad(IdPAutoridad),
CONSTRAINT FK_IdProfesional_area_psicosocial FOREIGN KEY(Profesional)REFERENCES tbl_profesionales(NumRegistro));

CREATE TABLE tbl_terapias_alternativas
(
IdHistoriaClinica int NOT NULL,
Fecha varchar(10)NOT NULL,
Caballo varchar(30)NOT NULL,
Terapia int NOT NULL,
PostPaso varchar(15)NOT NULL,
PostTrote varchar(15)NOT NULL,
PostGalope varchar(15)NOT NULL,
AsientoProf varchar(15)NOT NULL,
AsientoLig varchar(15)NOT NULL,
Tronco varchar(15)NOT NULL,
Cabeza varchar(15)NOT NULL,
Brazos varchar(15)NOT NULL,
Codos varchar(15)NOT NULL,
Manos varchar(15)NOT NULL,
Pelvis varchar(15)NOT NULL,
Piernas varchar(15)NOT NULL,
Pies varchar(15)NOT NULL,
AyudMontPelvis varchar(15)NOT NULL,
AyudMontPiernas varchar(15)NOT NULL,
AyudMontManos varchar(15)NOT NULL,
AsientoFlex varchar(15)NOT NULL,
SalidTrote varchar(15)NOT NULL,
SalidGalopeTr varchar(15)NOT NULL,
SalidGalopePaso varchar(15)NOT NULL,
AltoPaso varchar(15)NOT NULL,
AltoTrote varchar(15)NOT NULL,
AltoGalope varchar(15)NOT NULL,
Circulos varchar(15)NOT NULL,
Serpentinas varchar(15)NOT NULL,
Apoyos varchar(15)NOT NULL,
Equilibrio varchar(15)NOT NULL,
Flexibilidad varchar(15)NOT NULL,
CoordPsicomotriz varchar(15)NOT NULL,
FuerzaMuscular varchar(15)NOT NULL,
ManejoEsp varchar(15)NOT NULL,
Observaciones varchar(1000)NOT NULL,
Profesional varchar(20)NOT NULL,
CONSTRAINT PKtbl_terapias_alternativas PRIMARY KEY (IdHistoriaClinica, Fecha, Terapia),
CONSTRAINT FK_IdProfesional_terapias_alternativas FOREIGN KEY(Profesional)REFERENCES tbl_profesionales(NumRegistro),
CONSTRAINT FK_IdHistoriaClinica_terapias_alternativas FOREIGN KEY(IdHistoriaClinica)REFERENCES tbl_historia_clinica(IdHistoriaClinica),
CONSTRAINT FK_Nreg_Caballo_terapias_alternativas FOREIGN KEY(Caballo)REFERENCES tbl_caballos(Nrege),
CONSTRAINT FK_Terapia_terapias_alternativas FOREIGN KEY(Terapia)REFERENCES tbl_terapias(IdTerapia));