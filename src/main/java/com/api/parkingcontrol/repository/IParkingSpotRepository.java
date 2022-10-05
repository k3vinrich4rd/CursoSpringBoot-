package com.api.parkingcontrol.repository;

import com.api.parkingcontrol.model.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    /*
Estende o Jpa repository para utilizarmos  seus metodos prontos para utilizarmos para transações com o banco de dados
métodos:
Listar (Get)
Salvar(Post)
Atualizar(Put)
Deletar(Delete) etc

Importante: Quando estendemos ele já traz a anotação @Repository, então não é necessário colocar a anotação @Repository
 */
import java.util.UUID;
@Repository
public interface IParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

}
