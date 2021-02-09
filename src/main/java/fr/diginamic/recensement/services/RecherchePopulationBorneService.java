package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.exceptions.SaisieUtilisateurException;
import fr.diginamic.recensement.exceptions.ValeurIncoherenteException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ValeurIncoherenteException, SaisieUtilisateurException {
		
		String regex = "[+]?[0-9]+";
		boolean departementOk = false;

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		if (!Pattern.matches(regex, saisieMin)) {
			throw new SaisieUtilisateurException("Le minimum doit être un entier suppérieur à 0");
		}

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		if (!Pattern.matches(regex, saisieMax)) {
			throw new SaisieUtilisateurException("Le maximum doit être un entier suppérieur à 0");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;

		if (min < 0) {
			throw new ValeurIncoherenteException("Le minimum est inférieur à 0");
		} else if (max < 0) {
			throw new ValeurIncoherenteException("Le maximum est inférieur à 0");
		} else if (min > max) {
			throw new ValeurIncoherenteException("Le maximum est inférieur au minimum");
		}

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				departementOk = true;
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
		if (departementOk == false) {
			throw new SaisieUtilisateurException("Le code de département saisit n'existe pas");
		}
	}

}
