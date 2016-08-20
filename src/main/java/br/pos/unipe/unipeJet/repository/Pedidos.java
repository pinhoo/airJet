package br.pos.unipe.unipeJet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pos.unipe.unipeJet.model.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Long> {

}
