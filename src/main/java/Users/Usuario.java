/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Game.DeckProduct;
import java.util.ArrayList;

/**
 *
 * @author artur
 */
public class Usuario {
    private static int next_id_user = 1;
    private int id;
    protected String nome_usuario;
    protected String email;
    protected String senha;
    protected ArrayList<DeckProduct> decks;

    public Usuario() {
        this.id = next_id_user;
        next_id_user++;
    }
    
    
    public void editarUsuario(String nome_usuario, String email, String senha) {
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
    }
    
    public void removerDeckNome(String deck_name) {
        for(DeckProduct deck : decks) {
            if(deck.getDeck_name() == deck_name) {
                deck.removeToDeckList();
                break;
            }
        }
    }
    
    public void removerDeckID(int deck_id) {
        for(DeckProduct deck : decks) {
            if(deck.getId_deck() == deck_id) {
                deck.removeToDeckList();
                break;
            }
        }
    }

    public ArrayList<DeckProduct> getDecks() {
        return decks;
    }
    
}
