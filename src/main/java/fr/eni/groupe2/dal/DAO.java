package fr.eni.groupe2.dal;

import java.util.List;

import fr.eni.groupe2.messages.BusinessException;
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

	/**
	 * 
	 * @param id
	 * @return
	 * @throws DALException
	 * @throws BusinessException 
	 */
	T selectByID(int id) throws DALException, BusinessException; 
	
	/**
	 * 
	 * @return
	 * @throws DALException
	 * @throws BusinessException 
	 */
	List<T> selectAll() throws DALException, BusinessException; 
	
	/**
	 * 
	 * @param u
	 * @throws DALException
	 */
	void insert(T u) throws DALException; 
	
	/**
	 * 
	 * @param u
	 * @return
	 * @throws DALException
	 */
	T update (T u) throws DALException; 
	
	/**
	 * 
	 * @param u
	 * @throws DALException
	 */
	void delete(T u)throws DALException;
	
}
