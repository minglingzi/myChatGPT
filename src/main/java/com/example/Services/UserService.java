package com.example.Services;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.core.io.ResourceResolver;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.web.UserDto;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Singleton
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final ResourceResolver resourceResolver;

    @Inject
    public UserService(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    public List<UserDto> loadUsersFromCsv(String filePath) throws IOException {
        LOG.info("Loading users from CSV file: {}", filePath);
        String[] parts = filePath.split("\\.");
        if (parts.length < 2 || !"csv".equals(parts[parts.length - 1])) {
            throw new IllegalArgumentException("Invalid file type, must be a CSV file");
        }
        InputStreamReader reader = new InputStreamReader(resourceResolver.getResourceAsStream(filePath).get());
        List<UserDto> users = new CsvToBeanBuilder(reader)
                .withType(UserDto.class)
                .withSeparator(',')
                .build()
                .parse();

        return users;
    }
}