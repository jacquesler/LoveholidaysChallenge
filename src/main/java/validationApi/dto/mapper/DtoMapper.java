package validationApi.dto.mapper;

public interface DtoMapper<T, K> {
	
	public T map(K input);
}
