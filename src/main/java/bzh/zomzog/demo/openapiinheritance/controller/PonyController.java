package bzh.zomzog.demo.openapiinheritance.controller;

import bzh.zomzog.demo.openapiinheritance.controller.api.PonyApi;
import bzh.zomzog.demo.openapiinheritance.domain.api.Pegasi;
import bzh.zomzog.demo.openapiinheritance.domain.api.Pony;
import bzh.zomzog.demo.openapiinheritance.domain.api.Unicorn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PonyController implements PonyApi {

    @Override
    public ResponseEntity<Pony> getUsingGET() {
        final Unicorn unicorn = new Unicorn();
        unicorn.setName("Rarity");
        unicorn.setPonyType("unicorn");
        return ResponseEntity.ok(unicorn);
    }

    @Override
    public ResponseEntity<Pony> postUsingPOST(Pony pony) {
        if (pony instanceof Unicorn) {
            final Unicorn unicorn = new Unicorn();
            unicorn.setName("Rarity");
            unicorn.setPonyType("unicorn");
            return ResponseEntity.ok(unicorn);
        } else {
            final Pegasi pegasi = new Pegasi();
            pegasi.setName("Rainbow Dash");
            pegasi.setPonyType("pegasi");
            return ResponseEntity.ok(pegasi);
        }
    }
}
