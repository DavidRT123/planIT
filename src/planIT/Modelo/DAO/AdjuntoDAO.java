/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planIT.Modelo.DAO;

import planIT.Modelo.Adjunto;

/**
 *
 * @author David
 */
public interface AdjuntoDAO extends DAO<Adjunto, Integer>{
    public void eliminar(Adjunto adjunto);
}
