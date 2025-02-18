package io.git.yhugorocha.s3amazon.repository;

import io.git.yhugorocha.s3amazon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
