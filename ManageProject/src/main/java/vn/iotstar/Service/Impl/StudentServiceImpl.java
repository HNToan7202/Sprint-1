package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vn.iotstar.Entity.Student;
import vn.iotstar.Repository.StudentReposiotory;
import vn.iotstar.Service.IStudentService;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentReposiotory studentRepo;

	@Override
	public <S extends Student> S save(S entity) {
		return studentRepo.save(entity);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return studentRepo.findAll(pageable);
	}

	@Override
	public void flush() {
		studentRepo.flush();
	}

	@Override
	public <S extends Student> S saveAndFlush(S entity) {
		return studentRepo.saveAndFlush(entity);
	}

	@Override
	public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
		return studentRepo.findAll(example, pageable);
	}

	@Override
	public Optional<Student> findById(Long id) {
		return studentRepo.findById(id);
	}

	@Override
	public long count() {
		return studentRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		studentRepo.deleteById(id);
	}

	@Override
	public void delete(Student entity) {
		studentRepo.delete(entity);
	}

	@Override
	public Student getById(Long id) {
		return studentRepo.getById(id);
	}

	@Override
	public void deleteAll() {
		studentRepo.deleteAll();
	}

}