package br.pos.unipe.unipeJet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pos.unipe.unipeJet.model.UserPermission;

public interface UserPermissions extends JpaRepository<UserPermission, Long> {


}