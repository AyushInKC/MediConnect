package com.JavaJunkie.Hack2Skill.Controller;

import com.JavaJunkie.Hack2Skill.Models.CartModel;
import com.JavaJunkie.Hack2Skill.Repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
  private final CartRepository cartRepository;

  public CartController(CartRepository cartRepository){
      this.cartRepository=cartRepository;
  }
    @PostMapping("/save-cart")
    public CartModel saveCart(@RequestBody CartModel cartModel) {
        return cartRepository.save(cartModel);
    }
    @GetMapping("/list-cart")
    public List<CartModel> listCarts() {
        return cartRepository.findAll();
    }
}
