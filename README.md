# Labb-2-Programmering-forts-ttning
Ett enkelt cache-minne
Beskrivning:
OBS! (2^n betyder 2 upphöjt till n, dvs 2 multipicerat med sig själv n-1 antal gånger)
I denna labb ska ni programmera ett program som utför beräkningar och lagra dem i ett
minne. Tanken med att beräkningarna lagras är att programmet ska slippa
utföra samma beräkning två gånger, och detta är huvudpoängen med ett cache-minne.
Specifikationer
För att göra detta labb ni behöver skapa två klasser, Program och Model. Vi ska nu gå igenom
vad dessa klasser ska innehålla:
Model-klassen
Denna klass representerar den logiska modellen av programmet. I den klassen ska minnet
ligga, samt metoder för utföra beräkningarna samt hantera detta minne.
Klassen ska alltså ha följande:
En instans av HashMap<Integer, Long>
Detta är minnet där beräkningarna ska lagras
private Long getValueFromMemory(Integer value)
Denna metod ska få (n) som argument och returna 2^n om beräkningen finns, annars null.
private void addValueToMemory(Integer value, Long result)
Integer-värdet ska vara n
Long-värdet ska vara 2^n
public void clearMemory()
Denna metod ska rensa innehållet av minnet.
private long computePower(int power)
Denna metod tar (n) (större eller lika med 0) som parameter och returnerar (2^n). Denna
metod ska vara rekursiv.
public long compute2Power(int power)
Denna metod anropas av Program-klassen när användaren trycker på "Compute 2^n"
knappen. Metoden ska göra följande:
1) Först kolla om power är mindre än 0, då ska den kasta en IllegalArgumentException.
2) (Om power är inte mindre än 0), Kolla om beräkningen av 2^power finns i minnet redan,
då returnerar den värdet som finns där
3) Om beräkningen inte finns i minnet, så ska den först utföra beräkningen med hjälp av
computePower-metoden, därefter lägga den beräkningen i minnet med hjälp
av addValueToMemory-metoden och till slut returnera beräkningen.
Program-klassen
Denna klass är huvudprogrammet. I den klassen så ska all kod som hanterar interaktionen
med användaren ligga, samt en instans av Model-klassen för att hjälpa med att urföra
beräkningarna samt hantera minnet. Interaktionen kan göras på två sätt, välj ett av dem:
Vanlig input/output
Interaktionen med användaren sker via standard input/output(scanner är exempel på detta).
Programmet frågar användaren att mata in ett icke-negativt tal, men -1 för att rensa minnet
och -2 för att avsluta programmet.
Om användaren matar in -2, så ska programmet göra följande:
1) Rensa minnet
2) Skriva ut:
Memory cleard
Program quits
3) Avsluta programmet
Om användaren matar in -1, så ska programmet göra följande:
1) Rensa minnet
2) Skriva ut:
Memory cleard
Om användaren matar in något annat än ovan, så ska programmet göra följande:
1) Om det inmatade talet, n, är icke-negativt, så ska 2^n = result skrivas ut. Result kan
beräknas med hjälp av att anropa en compute2Power i Model-klassen.
2) Om det inmatade talet är negativt, så ska följande skrivas ut:
Invalid input. Detta ska ske i en try-catch sats(tänk på att compute2Power kastar en
excepåtion ifall den får en nagativ parameter).
Denna interaktion ska ligga in while loop som körs utan stop, det enda sättet att avsluta är
genom att mata in -2 och då avslutas hela programmet, antingen genom ett
system-anrop(System.exit(0)) eller en break-sats.
GUI
Ni kan hantera interaktionen med användaren genom ett GUI som ser ut som nedan:

![IMG](labb-2-Programmering fortsättning/GUI.jpg)


GUI:et ska ha föjande egenskaper:
Fönstret ska vara 600 i bredd, 300 i höjd. Denna storlek ska inte kunna ändras av användaren,
detta gör ni genom en metod i JFrame som heter setResizable, som ni ska sätta till false.
Fönstret ska också inte kunna stängas med den röda kryssen längst upp till höger, utan
användaren kan bara stänga av programmet genom att trycka på "Quit" knappen.
För att deaktivera den röda kryssen, ni behöver sätta setDefaultCloseOperation till
JFrame.DO_NOTHING_ON_CLOSE, istället för JFrame.EXIT_ON_CLOSE som vi gjort
tidigare.
Textrutan ska ha texten "0" från början. Lappen ska ha texten "Result: " från början.
Knapparna samt fönstret ska ha samma text så som det står i bilden ovan.
Knapparna ska agera på det sättet som följande:
Användarem matar in ett tal som är större än eller lika med 0. När hen trycker på "Compute
2^n" knappen, så ska lappen visa "Result: " + beräkningen av 2^n. Har användaren matat in
ett tal som är mindre en 0, då ska följande text visas i lappen: "Input a positive number
please!"
När användaren trycker på "Clear memory"r knappen, då ska allt i HashMappen rensan, och
texten "Memory cleared" visas i lappen. Slutligen om användaren
trycker på "Quit" kanppen, då ska minnet också rensas och programmet avslutas.
Kastas en exception av compute2Power metoden, då ska den fångas i
actionPerformed-metoden tillhörande "Compute 2^n"-kanppen och texten "input a positive
number please!" ska visas.