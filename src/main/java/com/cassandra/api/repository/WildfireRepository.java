package com.cassandra.api.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.cassandra.api.model.Wildfire;

public interface WildfireRepository extends CassandraRepository<Wildfire,Integer> {

}
