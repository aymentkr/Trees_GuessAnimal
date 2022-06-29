 package GuessAnimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Tree.Tree;
import Tree.Node;


/**** Tiere raten ***

Bei diesem klassischen Frage-Antwort-Spiel versucht der Computer 
ein vom Spieler ausgedachtes Tier zu erraten. Unbekannte Tiere 
werden dazugelernt.

Antworten immer mit 'j' or 'n'.


Ist es ein großes Tier?  j
Die Antwort ist: Elefant
Richtig? n
Glückwunsch! Du hast gewonnen!

Lass mich dazulernen! 

Welches Tier sollte ich erraten?  Nashorn 
Mit welcher Frage hätte ich das Tier erraten können?  Hat das Tier ein Horn? 
Danke! Schon gelernt.

Noch ein Spiel? j

Ist es ein großes Tier?  j
Hat das Tier ein Horn?  j
Die Antwort ist: Nashorn
Richtig? j
Juhu! Ich habe gewonnen!

Noch ein Spiel? n

***************************/

public class GuessAnimal {

	// Initialisierungen für reader (von Kommandozeile) 
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

	public GuessAnimal() {
		
	}

	public static void main(String[] args) throws IOException {
		// Begrüßungstext
		System.out.println("*** Tiere raten ***\n");
		System.out.println("Bei diesem klassischen Frage-Antwort-Spiel versucht der Computer \nein vom Spieler ausgedachtes Tier zu erraten. Unbekannte Tiere \nwerden dazugelernt.\n");
		System.out.println("Antworten immer mit 'j' or 'n'.\n");
		
		// Initialisierung des Baumes mit erster Frage und 2 Antworten   
		Node currNode = new Node("Ist es ein großes Tier?");
		currNode.SetLeftChild(new Node("Elefant"));
		currNode.SetRightChild(new Node("Maus"));
		Tree T = new Tree(currNode);
				
		// Schleife 
		do {
			System.out.print("\n");
			
			// Rate-Spiel geht immer mit der Wurzel los
			// Verweis auf Wurzel holen
			currNode = T.GetRoot();
						
			// Innerer Knoten 
			// sollte immer Frage enthalten, je nach Antwort nach links oder rechts weitergehen
			
			while (!currNode.IsLeaf()) {
				
				// Computer stellt Frage
				System.out.println(currNode.GetData());
				
				// Einlesen der Antwort
				if (GetAnswer().equalsIgnoreCase("j"))
					currNode = currNode.GetLeftChild();
				else
					currNode = currNode.GetRightChild();
				
			}
			
			// Blatt erreicht, enthält Anwort => Lösungsversuch und Möglichkeit zum Dazulernen
			if (currNode.IsLeaf()) {
				// Computer versucht zu lösen
				System.out.println("Die Antwort ist:"+currNode.GetData());
				
				// Verifizieren 
				System.out.print("Richtig? ");
				
				// Anwort eingeben
				if (GetAnswer().equalsIgnoreCase("j"))
					System.out.println("Juhu! Ich habe gewonnen!");
				else {
					System.out.println("Glückwunsch! Du hast gewonnen!");
				
					// hier muss der Rechner jetzt die nächste Frage und das unbekannte Tier lernen
					
					System.out.print("\nLass mich dazulernen! \n\nWelches Tier sollte ich erraten?  ");
					
					String correctAnimal = reader.readLine();
					String guessAnimal = currNode.GetData();

					System.out.print("Mit welcher Frage hätte ich das Tier erraten können?  ");
					
					String question = reader.readLine();
					
					currNode.SetData(question);
					currNode.SetLeftChild(new Node(correctAnimal));
					currNode.SetRightChild(new Node(guessAnimal));
					
					System.out.print("Danke! Schon gelernt.\n");
				}
			
			}
			
			// Weiterspielen?
			System.out.print("\nNoch ein Spiel? ");
		
		} while (GetAnswer().equalsIgnoreCase("j"));
		
		// Endezeile
		System.out.println("\n***************************\n");
	}
	
	
	private static String GetAnswer() throws IOException {

		String strAnswer = "";
		
		while (!strAnswer.equalsIgnoreCase("j") && !strAnswer.equalsIgnoreCase("n")) {
			
			// Anwort eingeben
			strAnswer = reader.readLine();
			
			// verifizieren
			if (!strAnswer.equalsIgnoreCase("j") && !strAnswer.equalsIgnoreCase("n"))
				System.out.println("Fehlerhafte Eingabe");
		}
			
		return strAnswer;
	}

}
