package fr.eni.groupe2.dal;

import java.util.List;

import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.messages.DALException;
/**
 * 
 * @author Groupe 2
 * @projet Project ENI ENCHERES 
 * @description Interface DAO GENERIQUE object d'accès aux données, un modèle d'accès aux données.
 *
 * @param <T>
 */
public interface DAO <T> {

	public void insert(T u) throws DALException; 
	public Utilisateur update (T u) throws DALException; 
	public T selectByID(int noUtilisateur) throws DALException; 
	public List<T> selectAll() throws DALException; 
	public void delete(T u);
	
}
