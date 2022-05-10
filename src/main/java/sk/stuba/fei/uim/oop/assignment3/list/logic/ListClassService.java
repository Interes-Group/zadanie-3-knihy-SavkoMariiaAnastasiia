package sk.stuba.fei.uim.oop.assignment3.list.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListClassRepository;

@Service
public class ListClassService implements IListClassService {
    @Autowired
    private ListClassRepository repository;
}
