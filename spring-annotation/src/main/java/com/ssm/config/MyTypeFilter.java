package com.ssm.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 自定义TypeFilter
 * @author interface
 *
 */
public class MyTypeFilter implements TypeFilter {
	/**
	 * MetadataReader:读取到的当前正在扫描的类的信息
	 * MetadataReaderFactory:可以获取到其他任何类信息
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前正在扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取当前类资源(类的路径)
		Resource resource = metadataReader.getResource();
		String className = classMetadata.getClassName();
		return false;
	}

}
