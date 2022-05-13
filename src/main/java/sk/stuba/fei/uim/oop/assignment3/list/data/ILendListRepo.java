package sk.stuba.fei.uim.oop.assignment3.list.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILendListRepo extends JpaRepository<LendList, Long> {//darmo redundant ja sa bojim vymazat lebo ste mi za to uz strhli bodik
}

