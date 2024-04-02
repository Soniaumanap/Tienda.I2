package com.tienda_l.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tienda_l.domain.Item;
import com.tienda_l.service.ItemService;

@Service
public class ItemServiceImpl
        implements ItemService {

    @Override
    public List<Item> gets() {
        return this.listaItems;
    }

    @Override
    public Item get(Item item) {
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                return i;
            }
        }
        return null;

    }

    @Override
    public void detele(Item item) {
        var posicion = -1;
        var existe = false;

        for (Item i : listaItems) {
            posicion++;
            if (i.getIdProducto() == item.getIdProducto()) {
                existe = true;
                break;
            }
        }

        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public void save(Item item) {
        var existe = false;
        //Se busca si el item ya existe en el carrito
        for (Item i : listaItems) {
            if (i.getIdProducto() == item.getIdProducto()) {
                i.setCantidad(i.getCantidad() + 1);
                existe = true;
                break;
            }
        }

        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }

    }

    @Override
    public void update(Item item) {
        for (Item i : listaItems){
            if(i.getIdProducto()== item.getIdProducto()){
                
                
            }
        }
    }

    @Override
    public void facturar() {
    }
}
