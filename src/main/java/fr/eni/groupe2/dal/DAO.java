package fr.eni.groupe2.dal;

import java.util.List;

import fr.eni.groupe2.bo.Utilisateur;
import fr.eni.groupe2.messages.DALException;

public interface DAO <T> {

	public void insert(T u) throws DALException; 
	public void update (T u); 
	public T selectByID(int noUtilisateur) throws DALException; 
	public List<T> selectAll() throws DALException; 
	public void delete(T u);
	
}
