package com.tailors.trynewmenu.ui.customer;

import com.tailors.trynewmenu.domain.account.Account;
import com.tailors.trynewmenu.service.customer.CustomerSignupService;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer/account")
public class AccountManagementController {

    @Autowired
    CustomerSignupService signupService;

    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@Valid @RequestBody CustomerDto.CreateEmailAccountRequest request, BindingResult result) {
        if (result.hasErrors()) {
            throw new IllegalArgumentException();
        }

        return signupService.createAccountByEmail(request);
    }
}
