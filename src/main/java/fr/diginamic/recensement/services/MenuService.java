package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.exceptions.SaisieUtilisateurException;
import fr.diginamic.recensement.exceptions.ValeurIncoherenteException;

/**
 * Classe représentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws ValeurIncoherenteException 
	 * @throws SaisieUtilisateurException 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws ValeurIncoherenteException, SaisieUtilisateurException;
}
