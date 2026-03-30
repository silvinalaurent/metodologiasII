public class ProcesadorPedidos { 
     
    public double procesarPedido(Pedido p) { 
        double total = 0; 
        for (int i = 0; i < p.items.length; i++) { 
            total += p.items[i].precio; 
        } 
         
        // Aplicar descuentos 
        if (p.cliente.tipo == 1) { 
            // Cliente normal 
            if (p.montoTotal > 1000) { 
                total = total * 0.95; 
            } 
            // Descuento por antigüedad 
            if (p.cliente.aniosConNosotros > 2) { 
                total = total * 0.98; 
            } 
        } else if (p.cliente.tipo == 2) { 
            // Cliente premium 
            total = total * 0.9; 
            // Descuento por frecuencia
            int compras = 0; 
            for (int j = 0; j < p.cliente.pedidos.length; j++) { 
                Pedido pedidoAnterior = p.cliente.pedidos[j]; 
                if (pedidoAnterior.fecha.isAfter(LocalDateTime.now().minusMonths(1))) { 
                    compras++; 
                } 
            } 
            if (compras > 3) { 
                total = total * 0.95; 
            } 
            // Descuento especial por ser VIP 
            if (p.cliente.nivelVip > 0) { 
                total = total * (1 - (0.05 * p.cliente.nivelVip)); 
            } 
        } else if (p.cliente.tipo == 3) { 
            // Cliente corporativo (esto lo hizo Juan hace 2 años y se fue) 
            // TODO: revisar esta lógica porque no funciona bien con los nuevos requerimientos 
            if (p.tieneFlagEspecial) { 
                total = total * 0.85; 
                // Aplicar impuestos especiales 
                if (p.categoria == "electronica") { 
                    total = total * 1.21; 
                } 
            } else { 
                total = total * 0.92; 
            } 
        } 
         
        // Cargos por envío (más de 50 líneas de ifs) 
        if (p.tipoEnvio == 1) { 
            total += 500; 
        } else if (p.tipoEnvio == 2) { 
            total += 1000; 
        } else if (p.tipoEnvio == 3) { 
            if (total > 5000) { 
                total += 0; 
            } else { 
                total += 800; 
            } 
        } else if (p.tipoEnvio == 4) { 
            total += 2000; 
        } 
         
        // Aplicar impuestos (esto es un copy-paste de otro método) 
        double impuestos = total * 0.21; 
        total += impuestos; 
         
        // TODO: revisar por qué a veces da negativo 
        return total > 0 ? total : 0; 
    } 
    
} 
