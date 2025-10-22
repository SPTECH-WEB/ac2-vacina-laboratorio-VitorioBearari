package sptech.school.estrutura;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sptech.school.Laboratorio;
import sptech.school.Vacina;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("2. TESTE DE ESTRUTURA - LABORATORIO")
class LaboratorioStructureTest {

    @Test
    @DisplayName("2.1. Deve possuir os atributos corretos com os modificadores apropriados")
    void testAtributos() throws NoSuchFieldException {
        // Verifica o atributo 'nome'
        Field nome = Laboratorio.class.getDeclaredField("nome");
        assertEquals(String.class, nome.getType(), "O tipo do atributo 'nome' deve ser String.");
        assertTrue(Modifier.isPrivate(nome.getModifiers()), "O atributo 'nome' deve ser privado.");

        // Verifica o atributo 'vacinas'
        Field vacinas = Laboratorio.class.getDeclaredField("vacinas");
        assertEquals(List.class, vacinas.getType(), "O tipo do atributo 'vacinas' deve ser List.");
        assertTrue(Modifier.isPrivate(vacinas.getModifiers()), "O atributo 'vacinas' deve ser privado.");
    }

    @Test
    @DisplayName("2.2. Deve possuir os construtores corretos")
    void testConstrutores() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        // Verifica o construtor sem argumentos
        Constructor<Laboratorio> construtorPadrao = Laboratorio.class.getDeclaredConstructor();
        assertTrue(Modifier.isPublic(construtorPadrao.getModifiers()), "O construtor sem argumentos deve ser público.");

        Laboratorio laboratorio = new Laboratorio();
        Field vacinas = Laboratorio.class.getDeclaredField("vacinas");
        vacinas.setAccessible(true);
        List<Vacina> vacinasDoLaboratorio = (List<Vacina>) vacinas.get(laboratorio);
        assertNotNull(vacinasDoLaboratorio, "O atributo 'vacinas' deve ser inicializado no construtor.");

    }

    @Test
    @DisplayName("2.3. Deve possuir os métodos getters e setters corretos com modificadores públicos")
    void testGettersSetters() throws NoSuchMethodException {
        // Verifica o getter e setter de 'nome'
        Method getNome = Laboratorio.class.getDeclaredMethod("getNome");
        assertEquals(String.class, getNome.getReturnType(), "O método 'getNome' deve retornar String.");
        assertTrue(Modifier.isPublic(getNome.getModifiers()), "O método 'getNome' deve ser público.");

        Method setNome = Laboratorio.class.getDeclaredMethod("setNome", String.class);
        assertTrue(Modifier.isPublic(setNome.getModifiers()), "O método 'setNome' deve ser público.");

        // Verifica o getter de 'vacinas'
        Method getVacinas = Laboratorio.class.getDeclaredMethod("getVacinas");
        assertEquals(List.class, getVacinas.getReturnType(), "O método 'getVacinas' deve retornar List.");
        assertTrue(Modifier.isPublic(getVacinas.getModifiers()), "O método 'getVacinas' deve ser público.");
    }

    @Test
    @DisplayName("2.4. Deve possuir o método adicionarVacina com modificador público")
    void testAdicionarVacina() throws NoSuchMethodException {
        Method adicionarVacina = Laboratorio.class.getDeclaredMethod("adicionarVacina", Vacina.class);
        assertTrue(Modifier.isPublic(adicionarVacina.getModifiers()), "O método 'adicionarVacina' deve ser público.");
    }

    @Test
    @DisplayName("2.5. Deve possuir o método buscarVacinaPorCodigo com modificador público")
    void testBuscarVacinaPorCodigo() throws NoSuchMethodException {
        Method buscarVacinaPorCodigo = Laboratorio.class.getDeclaredMethod("buscarVacinaPorCodigo", String.class);
        assertEquals(Vacina.class, buscarVacinaPorCodigo.getReturnType(), "O método 'buscarVacinaPorCodigo' deve retornar Vacina.");
        assertTrue(Modifier.isPublic(buscarVacinaPorCodigo.getModifiers()), "O método 'buscarVacinaPorCodigo' deve ser público.");
    }

    @Test
    @DisplayName("2.6. Deve possuir o método removerVacinaPorCodigo com modificador público")
    void testRemoverVacinaPorCodigo() throws NoSuchMethodException {
        Method removerVacinaPorCodigo = Laboratorio.class.getDeclaredMethod("removerVacinaPorCodigo", String.class);
        assertTrue(Modifier.isPublic(removerVacinaPorCodigo.getModifiers()), "O método 'removerVacinaPorCodigo' deve ser público.");
    }

    @Test
    @DisplayName("2.7. Deve possuir o método buscarVacinaComMelhorEficacia com modificador público")
    void testBuscarVacinaComMelhorEficacia() throws NoSuchMethodException {
        Method buscarVacinaComMelhorEficacia = Laboratorio.class.getDeclaredMethod("buscarVacinaComMelhorEficacia");
        assertEquals(Vacina.class, buscarVacinaComMelhorEficacia.getReturnType(), "O método 'buscarVacinaComMelhorEficacia' deve retornar Vacina.");
        assertTrue(Modifier.isPublic(buscarVacinaComMelhorEficacia.getModifiers()), "O método 'buscarVacinaComMelhorEficacia' deve ser público.");
    }

    @Test
    @DisplayName("2.8. Deve possuir o método buscarVacinaPorPeriodo com modificador público")
    void testBuscarVacinaPorPeriodo() throws NoSuchMethodException {
        Method buscarVacinaPorPeriodo = Laboratorio.class.getDeclaredMethod("buscarVacinaPorPeriodo", LocalDate.class, LocalDate.class);
        assertEquals(List.class, buscarVacinaPorPeriodo.getReturnType(), "O método 'buscarVacinaPorPeriodo' deve retornar List.");
        assertTrue(Modifier.isPublic(buscarVacinaPorPeriodo.getModifiers()), "O método 'buscarVacinaPorPeriodo' deve ser público.");
    }

    @Test
    @DisplayName("2.9. Deve garantir que não há setter para o atributo 'vacinas'")
    void testNaoExisteSetterParaVacinas() {
        Method[] methods = Laboratorio.class.getDeclaredMethods();

        boolean hasSetterForVacinas = false;
        for (Method method : methods) {
            if (method.getName().equals("setVacinas")) {
                hasSetterForVacinas = true;
                break;
            }
        }

        assertFalse(hasSetterForVacinas, "A classe 'Laboratorio' não deve possuir um setter para a lista 'vacinas'.");
    }
}