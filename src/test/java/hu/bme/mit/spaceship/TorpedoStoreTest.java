package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TorpedoStoreTest {

  private TorpedoStore store;

  @BeforeEach
  public void setUp() {
    this.store = new TorpedoStore(10);
  }

  @Test
  public void fire_Success() {
    boolean result = this.store.fire(1);
    assertTrue(result);
  }

  @Test
  public void fire_EmptyStore_ThrowsException() {
    TorpedoStore emptyStore = new TorpedoStore(0);
    assertThrows(IllegalArgumentException.class, () -> {
      emptyStore.fire(1);
    });
  }

  @Test
  public void getTorpedoCount_Success() {
    assertEquals(10, this.store.getTorpedoCount());
    this.store.fire(1);
    assertEquals(9, this.store.getTorpedoCount());
  }

  @Test
  public void isEmpty_WorksCorrectly() {
    assertFalse(this.store.isEmpty());
    TorpedoStore emptyStore = new TorpedoStore(0);
    assertTrue(emptyStore.isEmpty());
  }
}