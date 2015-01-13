Esta librería se basa en documentación oficial obtenida por medio del IFAI (Instituto Federal de Acceso a la Información). El documento puede ser consultado en el sitio de [INFOMEX](https://www.infomex.org.mx/gobiernofederal/moduloPublico/moduloPublico.action) con el folio `0610100135506`.

Cabe advertir que sólo la Secretaría de Hacienda y Crédito Público, a través del Servicio de Administración Tributaria, es la única instancia que oficialmente asigna las claves de RFC a los contribuyentes que así lo soliciten, a partir de la aplicación de este procedimiento a la base de datos del Padrón de Contribuyentes, con la finalidad de identificar homonimias y evitar la duplicidad de registros.


##A N T E C E D E N T E S

EL PRESENTE DOCUMENTO DESCRIBE DE MANERA GENÉRICA LOS PROCEDIMIENTOS PARA LA GENERACIÓN DE LA CLAVE DE REGISTRO FEDERAL DE CONTRIBUYENTES 10 POSICIONES TOMÁNDOSE COMO BASE LEGAL EL " INSTRUCTIVO PARA FORMACIÓN DEL REGISTRO FEDERAL DE CONTRIBUYENTES" EMITIDO POR LA DIRECCIÓN GENERAL DE RECAUDACIÓN EN EL MES DE ABRIL DE 1988.

ASI MISMO SE DESCRIBE LA FORMA EN QUE SE GENERA LA CLAVE DIFERENCIADORA (HOMONIMA) ASI COMO EL DIGITO VERIFICADOR, OBTENIÉNDOSE CON ESTOS DOS ELEMENTOS LA CLAVE DE REGISTRO FEDERAL DE CONTRIBUYENTES A 13 POSICIONES, MISMA QUE ES DADA A CONOCER A LOS CONTRIBUYENTES SUJETOS A IMPUESTOS FEDERALES PARA SU UTILIZACIÓN ANTE LA SECRETARIA DE HACIENDA Y CRÉDITO PÚBLICO.

##I N D I C E

- IV. REGLAS DE LA CONFORMACIÓN DE LA CLAVE DE R.F.C.
- IV.1 REGLAS GENERALES
- 1.1  FUENTES DE INFORMACIÓN
- 1.2  ESTRUCTURA DE LA CLAVE
- IV.2 REGLAS ESPECÍFICAS
- 2.1  PERSONAS MORALES
- 2.2  PERSONAS FÍSICAS
- V.   PROCEDIMIENTO PARA OBTENCIÓN DE LA CLAVE DIFERENCIADORA
- VI.  PROCEDIMIENTO PARA EL CÁLCULO DEL DÍGITO VERIFICADOR

##ANEXOS:

- TABLA 1.
- TABLA 11.
- TABLA 111.
- LISTA COMPLETA DE PALABRAS INCONVENIENTES.
- LISTA DE PALABRAS INCONVENIENTES QUE NO SE UTILIZAN EN LA GENERACIÓN DE LA CLAVE DEL REGISTRO FEDERAL DE CONTRIBUYENTES.
- RUTINA PARA EL CÁLCULO HOMONIMIA Y DÍGITO VERIFICADOR.


### 1.1  FUENTES DE INFORMACIÓN

#### A) Personas Morales.

Copia del acta constitutiva o en caso copia del documento que motivó su origen.

#### B) Personas Físicas.

Acta de Nacimiento, Cartilla, Pasaporte o Certificado de Estudios de Enseñanza Pública.

Tratándose de Personas Físicas Asalariadas, se formará con los datos que proporcione el empleador (retenedor).

### 1.2 ESTRUCTURA DE LA CLAVE

* En cuanto a sus primeras 10 posiciones, la clave de Registro Federal de Contribuyentes, consta de un espacio, tres letras y seis dígitos para Personas Morales y de cuatro letras y seis dígitos en el caso de Personas Físicas.
* Una vez asignada la clave a 10 posiciones, la autoridad fiscal generará 2 posiciones para la clave diferenciadora de homonimia y una posición para el dígito verificador.
* La clave completa de Registro Federal de Contribuyentes consta de 13 posiciones.

### 2.1 PERSONAS MORALES

#### REGLA 1ª.

Para la formación de la clave se tomarán como elemento de orden, las tres primeras letras de las tres primeras palabras de la denominación o razón social tal y como esté manifestando en la copia del acta constitutiva o en caso en la copia del documento que motivó su origen, ejemplo:

`Sonora Industrial Azucarera, S. de R. L.`

<table>
<tr>
<td>Primera Palabra: Sonora</td>
<td>S</td>
</tr>
<tr>
<td>Segunda palabra: Industrial</td>
<td>I</td>
</tr>
<tr>
<td>Tercera Palabra: Azucarera</td>
<td>A</td>
</tr>
</table>

Resultado de la expresión alfabética: `SIA`

#### REGLA 2ª.

A continuación se anotará la fecha de constitución o creación, en el siguiente orden:

Año: Se tomarán las dos últimas cifras, escribiéndolas con números                   arábigos.

Mes: Se tomará el mes de constitución o creación, en su número de orden, en un año calendario escribiéndolo con números arábigos.

Día: Se escribirá en números arábigos.

Ejemplo:

Año:    1982         82

Mes:    Noviembre   11

Día:    29           29

Dando como resultado la expresión numérica: 821129

Y completando con la expresión alfabético numérica tendremos:

Sonora Industrial Azucarera, S. de. R.L.       SIA-821129

Herrajes, Cortinas y Maquinaria, S.A.         HCM-841122

Artículos de piel y Baúles, S. de R. L.         APB-791215

Cuando en el mes o día, de la fecha de constitución, aparezca solamente un guarismo se le antepondrá un cero, ejemplos:

Año: 1983       83

Mes: Marzo      03

Día: 5          05

Como resultado tendremos la expresión numérica:    830305

Y contemplando la clave alfabético numérica tendremos:

Tecnología y Equipo contra Incendios, S.A.         TEC-830305

Internacional Turística Flacón, S.A.               ITF-850128

Artículos de Caza y Pesca, S. de R. L.              ACP-860215



REGLA 3ª.

Cuando la letra inicial de cualquiera de las tres primeras palabras de la denominación o razón social sea compuesta, únicamente se anotará la inicial de esta. En la Ch la C y en la Ll la L, ejemplos:

Champion Mexicana de Bujías, S.A.CMB-830702

Casa Chávez de maquinaria, S. de R. L.CCM-800620

Artículos de Piel y Chamarras, S. de R.L.APC-810202

Llantas, Cámaras y Refacciones, S. de R.L.LCR-851015

Candados, Llaves y Cerraduras, S.A.CLC-830820

Luis Molina Llorantes y Cía., S. de R.L.LML-860911

REGLA 4ª.

En los casos en que la denominación o razón social esté compuesta sólo de iniciales, para estos efectos se consideran palabras, por tanto deben tomarse en cuenta como tales, ejemplos:

F.A.Z., S.A.                 FAZ-870420

U.S. Ruber Mexicana, S.A.     USR-860201

H. Prieto y Martínez, S. de R.L.  HPM-841221

REGLA 5ª.

Las abreviaturas: "S. en N.C.","S. en C.", "S. de R.L.", "S. en C. por A.", "S.A.", "S.A. de C.V.", "S.N.C.", "S.C.", "A.C.", "A. en P.", "S.C.L.", "S.C.S.", que expresan tipo de sociedad en las denominaciones o razones sociales, no se tomarán en consideración para efectos de conformación de las claves, ejemplos:

Guantes Industriales Guadalupe, S. en C.GIG-841215

Construcciones Metálicas Mexicanas, S.A.CMM-830120

Fundición de Precisión Eutectic, S. de R.L.FPE-861125





REGLA 6ª.

Si la denominación o razón social se comprende de dos elementos, para efectos de la conformación de la clave, se tomará la letra inicial de la primera palabra y las dos primeras letras de la segunda, ejemplos:

Fonograbaciones Cinelandia, S. de R.L.FCI-841019

Aceros Ecatepec, S.A. AEC-890130

Distribuidora Ges, S.A.DGE-850628

REGLA 7ª.

Si la denominación o razón social se compone de un solo elemento, para efectos de conformación de la clave, se tomarán las tres primeras letras consecutivas del mismo, ejemplo:

Arsuyama, S.A.ARS-821129

Calidra, S.A.CAL-850920

Electrólisis, S.A.ELE-840821

REGLA 8ª.

Cuando la denominación o razón social se componga de un solo elemento y sus letras no completen las tres requeridas, para efectos de conformación de la clave, se tomaran las empleadas por el contribuyente y las restantes se suplirán con una "X", ejemplos:

Al, S.A.     ALX-830101

Z, S.A.      ZXX-860110

REGLA 9ª.

Cuando en la denominación o razón social figuren artículos, preposiciones y conjunciones o contracciones no se tomaran como elementos de integración de la clave, ejemplos:

El abastecedor Ferretero, S.A.AFE-840510

Cigarros la Tabacalera Mexicana, S.A. de C.V.  CTM-860901

Los Viajes Internacionales de Marco Polo, S.A. VIM-824225

Artículos y Accesorios para Automóviles, S.A. AAA-800521

Productos de la Industria del Papel, S.A.PIP-811231

REGLA 10ª.

Cuando la denominación o razón social contenga en algún o en sus tres primeros elementos números arábigos, o números romanos, para efectos de conformación de la clave éstos se tomaran como escritos con letra y seguirán las reglas ya establecidas, ejemplos:

El 12, S.A.DOC-801029

   (DOCE)

El 2 de Enero, S de R.L.DEN-840101

       (DOS)

El 505, S.A.QCI-851215

        (QUINIENTOS CINCO)

Editorial Siglo XXI, S.A.            ESV-831114

                 (VEINTIUNO)

REGLA 11ª.

Cuando aparezcan formando parte de la denominación o razón social, la palabra Compañía o su abreviatura Cía., así como la palabra Sociedad o su abreviatura Soc., no se incluirán en la conformación de la clave, ejemplos:

Compañía Periodística Nacional, S.A.                       PNA-861121

Cía. De Artículos Eléctricos, S. de R.L.                 AEL-850110

Cía. Nal. De Subsistencias Mexicanas, S.A.             NSM-841011

   Pimienta Hnos. y Cía., S.A.                        PHN-830228

Sociedad Cooperativa de Producción Agrícola de Michoacán CPA-861016

Sociedad de Consumo Agrícola del Sur, S.C.L.           CAS-821110

Sociedad de Producción Rural de Sonora               PRS-800101

REGLA 12ª.

Cuando aparezcan formando parte de la denominación o razón social los caracteres especiales, éstos deben de excluirse para el cálculo del homónimo y del dígito verificador. Los caracteres se interpretarán, sí y sólo si, están en forma individual dentro del texto de la denominación o razón social. (Anexo VI) Ejemplos:

| DENOMINACION O RAZON SOCIAL | RFC GENERADO |
| --- | --- |
| LA S@NDIA S.A DE C.V. | . SND-861121 |
| LA @ S.A. DE C.V | ARR-860120 |
| LA @ DEL % SA DE CV | APO-830120 |
| @ COMER.COM | ACO-800210 |
| LAS ( BLANCAS ) | APB-700202 |
| EL # DEL TEJADO | NET-010202 |
| LA / DEL SUR | DSU-010102 |
| EL C@FE.NET | CFE-030210 |

OBSERVACIÓN:

En los casos en que se presenten cambios de régimen de capital, seguirá considerándose la misma Clave de R.F.C. asignada inicialmente, ejemplos:

    DATOS ACTUALES                       CAMBIOS

Instrumentos Bristol, S.A. de C.V.          Instrumentos Bristol, S.A.

      IBR-700104                              IBR-700104

Lubricantes y Filtros, S.A.          Lubricantes y Filtros, S.A. de C.V.

      LFI-571130                               LFI-571130



2.2 PERSONAS FÍSICAS

REGLA 1ª.

Se integra la clave con los siguientes datos:

1.La primera letra del apellido paterno y la siguiente primera vocal del mismo.

2.La primera letra del apellido materno.

3.La primera letra del nombre.

Ejemplo:

Juan Barrios Fernández

Apellido paterno           BarriosBA

Apellido materno           FernándezF

Nombre                   JuanJ

Resultando de la expresión alfabética:BAFJ

Eva Iriarte Méndez

Apellido paterno            IriarteII

Apellido materno           MéndezM

Nombre                   EvaE

Resultado de la expresión alfabética:IIME

REGLA 2ª.

A continuación se anotará la fecha de nacimiento del contribuyente, en el siguiente orden:

Año: Se tomarán las dos últimas cifras, escribiéndolas con números arábigos.

Mes: Se tomará el mes de nacimiento en su número de orden, en un año de calendario,             escribiéndolo con números arábigos.

Día: Se escribirá con números arábigos.

Ejemplos:

Año       1970          70

Mes       Diciembre     12

Día        13           13

Dando como resultado la expresión numérica:    701213

Y complementando con la expresión alfabética numérica tendremos:

Juan Barrios Fernández           BAFJ 701213

Eva Iriarte Méndez              IIME 691117

Cuando en el año, mes o día, de la fecha de nacimiento, aparezca solamente un guarismo se le antepondrá un CERO.

Ejemplos:

Año       1907        07

Mes       Abril       04

Día        1º.         01

Como resultado tendremos la expresión numérica:    070401

Y completando la clave alfabético numérica tendremos:

Juan Barrios FernándezBAFJ-070401

Francisco Ortíz PérezOIPF-290205

Manuel Martínez HernándezMAHM-570102

Gabriel Courturier MorenoCOMG-600703



REGLA 3ª.

Cuando la letra inicial de cualquiera de los apellidos o nombre sea compuesta, únicamente se anotará la inicial de ésta. En la Ch la C y en la Ll la L.

Ejemplos:

Manuel Chávez GonzálezCAGM-240618

Felipe Camargo LlamasCALF-450228

    Charles Kennedy Truman        KETC-511012

REGLA 4ª.

En los casos en que el apellido paterno de la persona física se componga de una o dos letras, la clave se formará de la siguiente manera:

1.La primera letra del apellido paterno.

2.La primera letra del apellido materno.

3.La primera y segunda letra del nombre.

Ejemplo:

Alvaro de la O LozanoOLAL-401201

Ernesto Ek RiveraERER-071120

REGLA 5ª.

Cuando el apellido paterno o materno sean compuestos, se tomará para la clasificación la primera palabra que corresponda a cualquiera de ellos.

Ejemplos:

Dolores San Martín DávalosSADD-180812

Mario Sánchez de la Barquera GómezSAGM-190224

Antonio Jiménez Ponce de LeónJIPA-170808

REGLA 6ª.

Cuando el nombre es compuesto, o sea, que esta formado por dos o más palabras, se tomará para la conformación la letra inicial de la primera, siempre que no sea MARIA o JOSE dado su frecuente uso, en cuyo caso se tomará la primera letra de la segunda palabra.

Ejemplos:

Luz María Fernández JuárezFEJL-200205

José Antonio Camargo HernándezCAHA-211218

María Luisa Ramírez SánchezRASL-251112

REGLA 7ª.

En los casos en que la persona física tenga un solo apellido, se conformará con la primera y segunda letras del apellido paterno o materno, según figure en el acta de nacimiento, más la primera y segunda letras del nombre.

Ejemplos:

Juan MartínezMAJU-420116

Gerarda ZafraZAGE-251115

REGLA 8ª.

Cuando en el nombre de las personas físicas figuren artículos, preposiciones, conjunciones o contracciones no se tomarán como elementos de integración de la clave, ejemplos:

Carmen de la Peña RamírezPERC-631201

Mario Sánchez de los CobosSACM-701110

Roberto González y DuránGODR-600101

Juan del Valle MartínezVAMJ-691001

REGLA 9ª.

Cuando de las cuatro letras que formen la expresión alfabética, resulte una palabra inconveniente, la ultima letra será sustituida por una " X ".

| BUEI | BUEX | KOGE | KOGX |
| --- | --- | --- | --- |
| BUEY | BUEX | KOJO | KOJX |
| CACA | CACX | KAKA | KAKX |
| CACO | CACX | KULO | KULX |
| CAGA | CAGX | MAME MAMX |  |
| CAGO | CAGX | MAMO |  MAMX |
| CAKA | CAKX | MEAR | MEAX |
| COGE | COGX | MEON | MEOX |
| COJA | COJX | MION | MIOX |
| COJE | COJX | MOCO | MOCX |
| COJI | COJX | MULA | MULX |
| COJO | COJX | PEDA | PEDX |
| CULO | CULX | PEDO | PEDX |
| FETO | FETX | PENE | PENX |
| GUEY | GUEX | PUTA | PUTX |
| JOTO | JOTX | PUTO | PUTX |
| KACA | KACX | QULO | QULX |
| KACO | KACX | RATA | RATX |
| KAGA | KAGX | RUIN | RUIX |
| KAGO | KAGX |  |  |





REGLA 10ª.

Cuando aparezcan formando parte del nombre, apellido paterno y apellido materno los caracteres especiales, éstos deben de excluirse para el cálculo del homónimo y del dígito verificador. Los caracteres se interpretarán, sí y sólo si, están en forma individual dentro del nombre, apellido paterno y apellido materno. Ejemplos:

Roberto O'farril CarballoOACR-661121

Rubén D'angelo FargoDAFR-710108

Luz Ma. Fernández JuárezFEJL-830120

OBSERVACIÓN:

En caso de la mujer, se deberá usar el nombre de soltera.



PROCEDIMIENTO PARA OBTENER LA CLAVE DIFERENCIADORA DE HOMONIMIA.

1.Se asignaran valores a las letras del nombre o razón social de acuerdo a la tabla del Anexo 1.

Ejemplo:

Gómez Díaz Emma

G = 17espacio = 00espacio = 00

O = 26           D = 14     E = 15

M = 24     I = 19     M = 24

E = 15     A = 11            M = 24

Z = 39         Z = 39             A = 11

NOTA: No se debe permitir caracteres especiales en el nombre, excepto el &

2.Se ordenan los valores de la siguiente manera:

 G  O  M  E  Z     D   I  A  Z     E  M  M A

017 26 24 15 39 00 14 19 11 39 00 15 24 24 11

Se agrega un cero al valor de la primera letra para uniformar el criterio de los números a tomar de dos en dos.

3.Se efectuaran las multiplicaciones de los números tomados de dos en dos para la posición de la pareja:

01 \* 1 = 190 \* 0 = 090 \* 0 = 0

17 \* 7 = 11500 \* 0 = 0     00 \* 0 = 0

72 \* 2 = 14401 \* 1 = 101 \* 1 = 1

26 \* 6 = 156 14 \* 4 = 5615 \* 5 = 75

62 \* 2 = 124 41 \* 1 = 4152 \* 2 = 104

24 \* 4 = 96 19 \* 9 = 17124 \* 4 = 96

41 \* 1 = 41 91 \* 1 = 9142 \* 2 = 54

15 \* 5 = 75 11 \* 1 = 1124 \* 4 = 96

53 \* 3 = 159 13 \* 3 = 3941 \* 1 = 41

39 \* 9 = 351 39 \* 9 = 35111 \* 1 = 11

4. Se suma el resultado de las multiplicaciones y del resultado obtenido, se tomaran las tres ultimas cifras y estas se dividen entre el factor 34, ejemplo:

El resultado de la suma de las multiplicaciones es:

2535

              15   cociente

              34| 535

195

25residuo



5. Con el cociente y el residuo se consulta la tabla del Anexo II y se asigna la homonimia.

Obteniéndose:

15 = G

25 = R

por lo tanto la homonimia será " GR " .

R.F.C. CON HOMONIMIA :  GODE561231GR

























A N E X O I

TABLA PARA ASIGNAR VALORES A LOS CARACTERES QUE APARECEN EN EL NOMBRE AL QUE SE LE CALCULARA LA CLAVE DIFERENCIADORA DE HOMONIMO

| Espacio = 00 | B = 12 | O = 26 |
| --- | --- | --- |
| 0 = 00 | C = 13 | P =27 |
| 1 = 01 | D = 14 | Q = 28 |
| 2 = 02 | E = 15 | R = 29 |
| 3 = 03 | F = 16 | S = 32 |
| 4 = 04 | G = 17 | T = 33 |
| 5 =05 | H = 18 | U = 34 |
| 6 = 06 | I = 19 | V = 35 |
| 7 = 07 | J = 21 | W = 36 |
| 8 = 08 | K = 22 | X = 37 |
| 9 = 09 | L = 23 | Y = 38 |
| & = 10 | M = 24 | Z = 39 |
| A = 11 | N = 25 | Ñ = 40 |







A N E X O I I

TABLA DE VALORES QUE SE ASIGNAN A LA CLAVE DIFERENCIADORA DE HOMONIMIO EN BASE AL COEFICIENTE Y AL RESIDUO

| 0 = 1 | 17 = I |
| --- | --- |
| 1 = 2 | 18 = J |
| 2 = 3 | 19 = K |
| 3 = 4 | 20 = L |
| 4 = 5 | 21 = M |
| 5 = 6 | 22 = N |
| 6 = 7 | 23 = P |
| 7 = 8 | 24 = Q |
| 8 = 9 | 25 = R |
| 9 = A | 26 = S |
| 10 = B | 27 = T |
| 11 = C | 28 = U |
| 12 = D | 29 = V |
| 13 = E | 30 = W |
| 14 = F | 31 = X |
| 15 = G | 32 = Y |
| 16 = H | 33 = Z |





A N E X O I I I

TABLA DE VALORES PARA LO GENERACIÓN DEL CÓDIGO VERIFICADOR DEL REGISTRO FEDERAL DE CONTRIBUYENTES.

| CARACTER | VALOR | CARACTER | VALOR | CARCTER | VALOR |
| --- | --- | --- | --- | --- | --- |
| 0 | 00 | D | 13 | P | 26 |
| 1 | 01 | E | 14 | Q | 27 |
| 2 | 02 | F | 15 | R | 28 |
| 3 | 03 | G | 16 | S | 29 |
| 4 | 04 | H | 17 | T | 30 |
| 5 | 05 | I | 18 | U | 31 |
| 6 | 06 | J | 19 | V | 32 |
| 7 | 07 | K | 20 | W | 33 |
| 8 | 08 | L | 21 | X | 34 |
| 9 | 09 | M | 22 | Y | 35 |
| A | 10 | N | 23 | Z | 36 |
| B | 11 | & | 24 | BLANCO | 37 |
| C | 12 | O | 25 | Ñ | 38 |

TODOS LOS CARACTERES QUE NO SE ENCUNTREN EN ESTA TABLA SE LES ASIGNARA UN VALOR DE " 00 ".

ANEXO IV

LISTA COMPLETA DE PALABRAS INCONVENIENTES CON SUS PALABRAS CORRECTAS

| PALABRAS INCONVENIENTES | PALABRA CORRECTA | PALABRAS INCONVENIENTES | PALABRA CORRECTA |
| --- | --- | --- | --- |
| BUEI | BUEX | BUEY | BUEX |
| CACA | CACX | CACO | CACX |
| CAGA | CAGX | CAGO | CAGX |
| CAKA | CAKX | CAKO | CAKX |
| COGE | COGX | COJA | COJX |
| COJE | COJX | COJI | COJX |
| COJO | COJX | CULO | CULX |
| FETO | FETX | GUEY | GUEX |
| JOTO | JOTX | KACA | KACX |
| KACO | KACX | KAGA | KAGX |
| KAGO | KAGX | KOGE | KOGX |
| KOJO | KOJX | KAKA | KAKX |
| KULO | KULX | MAME | MAMX |
| MAMO | MAMX | MEAR | MEAX |
| MEAS | MEAX | MEON | MEOX |
| MION | MIOX | MOCO | MOCX |
| MULA | MULX | PEDA | PEDX |
| PEDO | PEDX | PENE | PENX |
| PUTA | PUTX | PUTO | PUTX |
| QULO | QULX | RATA | RATX |
| RUIN | RUIX |  |  |

ANEXO V

LISTA DE PALABRAS QUE NO SE UTILIZAN EN LA FORMACIÓN DE LA CLAVE DEL REGISTRO FEDERAL DE CONTRIBUYENTES.

| PERSONAS MORALES | PERSONAS FISICAS |  |
| --- | --- | --- |
| EL | LA | DE |
| S DE RL | SA DE CV | LA |
| DE | LOS | LAS |
| LAS | Y | MC |
| DEL | SA | VON |
| COMPAÑÍA | CIA | DEL |
| SOCIEDAD | SOC | LOS |
| COOPERATIVA | COOP | Y |
| S EN C POR A | A EN P | MAC |
| S EN NC | S EN C | VAN |
| PARA | EN | MI |
| POR | CON |  |
| AL | SUS |  |
| E | SC |  |
| SCL | SCS |  |
| SNC | THE |  |
| OF | AND |  |
| COMPANY | CO |  |
| MC | MAC |  |
| VON | VAN |  |
| MI | A |  |
| SRL CV | SA DE CV MI |  |
| SA MI | COMPA&ÍA |  |
| SRL CV MI | SRL MI |  |

















ANEXO VI

LISTA DE CARACTERES ESPECIALES Y VALORES QUE TOMARÁN SÓLO SI ESTÁN EN FORMA INDIVIDUAL DENTRO DEL TEXTO DEL NOMBRE O DENOMINACIÓN SOCIAL

| PERSONAS MORALES | PERSONAS FÍSICAS |
| --- | --- |
| CARÁCTER | VALOR | CARÁCTER | VALOR |
| @ | ARROBA | ´ | APOSTROFE |
| ´ | APOSTROFE | . | PUNTO |
| % | PORCIENTO |  |  |
| # | NUMERO |  |  |
| ! | ADMIRACION |  |  |
| . | PUNTO |  |  |
| $ | PESOS |  |  |
| " | COMILLAS |  |  |
| - | GUION |  |  |
| / | DIAGONAL |  |  |
| + | SUMA |  |  |
| ( | ABRE PARENTESIS |  |  |
| ) | CIERRA PARENTESIS |  |  |





PROCEDIMIENTO PARA CALCULAR EL DIGITO VERIFICADOR DEL REGISTRO FEDERAL DE CONTRIBUYENTES

1.Se asignaran los valores del Anexo III a las letras y números del registro federal de contribuyentes formado a 12 posiciones

Ejemplo: GODE 561231GR

G = 16

O = 25

D = 13

E = 14

5 = 05

6 = 06

1 = 01

2 = 02

3 = 03

1 = 01

G = 16

R = 28



2.Una vez asignados los valores se aplicara la siguiente forma tomando como base el factor 13 en orden descendente a cada letra y número del R.F.C. para su multiplicación, de acuerdo a la siguiente formula:

(Vi \* (Pi + 1)) + (Vi \* (Pi + 1)) + ..............+ (Vi \* (Pi + 1))   MOD 11

Vi  Valor asociado al carácter de acuerdo a la tabla del Anexo III.

Pi  Posición que ocupa el i-esimo carácter tomando de derecha a izquierda es decir P toma los valores de 1 a 12.



Ejemplo:

D = (16(13) + 25 (12)+13 (11) +14 (10) + 05 (9) + 06 (8) + 01 (7) + 02 (6) + 03 (5) + 01 (4)+16 (3) + 28 (2)) = 1026

Donde el resultado será: 1026

3.El resultado de la suma se divide entre el factor 11.

93  cociente

11 | 1026

036

03  residuo

Si el residuo es igual a cero, este será el valor que se le asignara al dígito verificador.

Si el residuo es mayor a cero se restara este al factor 11: 11-3 =8

Si el residuo es igual a 10 el dígito verificador será " A".

Si el residuo es igual a cero el dígito verificador será cero. Por lo tanto " 8 " es el dígito verificador de este ejemplo:  GODE561231GR8.