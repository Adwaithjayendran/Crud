package com.ty.service;



import com.ty.entity.Product;
import com.ty.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void testDelete_ProductExists_ProductIsDeleted() throws Exception {
        // Arrange
        FakeProductRepository fakeRepo = new FakeProductRepository();
        ProductService service = new ProductService();
        injectRepo(service, fakeRepo);

        Product product = new Product();
        product.setProdId(1);
        fakeRepo.save(product);

        // Act
        service.delete(1);

        // Assert
        assertFalse(fakeRepo.findById(1).isPresent(), "Product should be deleted");
    }

    @Test
    void testFind_ProductExists_ProductIsFetched() throws Exception {
        // Arrange
        FakeProductRepository fakeRepo = new FakeProductRepository();
        ProductService service = new ProductService();
        injectRepo(service, fakeRepo);

        Product product = new Product();
        product.setProdId(1);
        fakeRepo.save(product);

        // Act
        Optional<Product> findProductById = service.FindProductById(1);
        System.out.println(findProductById.get());

        // Assert
        assertFalse(fakeRepo.findById(1).isEmpty(), "Product is not available");
    }
    
    // Inject fake repository into service using reflection
    private void injectRepo(ProductService service, ProductRepository repo) throws Exception {
        Field field = ProductService.class.getDeclaredField("repo");
        field.setAccessible(true);
        field.set(service, repo);
    }

    // Fake in-memory ProductRepository with basic functionality
    static class FakeProductRepository implements ProductRepository {
        private final Map<Integer, Product> store = new HashMap<>();

        @Override
        public Optional<Product> findById(Integer id) {
            return Optional.ofNullable(store.get(id));
        }

        @Override
        public void delete(Product entity) {
            store.remove(entity.getProdId());
        }

        @Override
        public <S extends Product> S save(S entity) {
            store.put(entity.getProdId(), entity);
            return entity;
        }

        @Override
        public Iterable<Product> findAll() {
            return store.values();
        }

		@Override
		public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(Integer id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Product> findAllById(Iterable<Integer> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void deleteById(Integer id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllById(Iterable<? extends Integer> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends Product> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Product> findProductByProdName(String prodName) {
			// TODO Auto-generated method stub
			return null;
		}

        // You can throw UnsupportedOperationException for unused methods
    }
}
