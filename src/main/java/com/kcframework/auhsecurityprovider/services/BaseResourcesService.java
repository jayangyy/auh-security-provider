/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.services;

import com.kcframework.auhsecurityprovider.domains.Resource;
import com.kcframework.auhsecurityprovider.mappers.BaseResourceMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jayang
 */
@Service
public class BaseResourcesService extends BaseService<Resource> {

    public List<Resource> getResourceByRoleName(String rolename) {
        return ((BaseResourceMapper) mapper).getResourceByRoleName(rolename);
    }
    public List<Resource> getResourceByUserId(String userId) {
        return ((BaseResourceMapper) mapper).getResourceByUserId(userId);
    }
}
