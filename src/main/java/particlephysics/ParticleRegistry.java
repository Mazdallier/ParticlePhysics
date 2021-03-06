package particlephysics;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import particlephysics.entity.particle.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class ParticleRegistry
{

    public static ArrayList<Class> particles = new ArrayList();

    public static void populateParticleList()
    {
        particles.add(ClayParticle.class);
        particles.add(CoalParticle.class);
        particles.add(ConcentratedParticle.class);
        particles.add(SandParticle.class);
        particles.add(SeedParticle.class);
        particles.add(SplitParticle.class);
        particles.add(CharcoalParticle.class);
        particles.add(GlassParticle.class);
        particles.add(PaperParticle.class);
        particles.add(BlankParticle.class);
        particles.add(GunpowderParticle.class);
        particles.add(BlazepowderParticle.class);
        particles.add(LeafParticle.class);
    }

    public static Hashtable<Class, IIcon> icons = new Hashtable<Class, IIcon>();

    public static void populateIcons(IIconRegister register)
    {

        for (int i = 0; i < particles.size(); i++)
        {
            IIcon particleIcon = register.registerIcon(ModParticlePhysics.ID + ":" + particles.get(i).getName().substring("particlephysics.entity.particle.".length()));
            icons.put(particles.get(i), particleIcon);
        }

    }

    public static IIcon getIconFromInstance(TemplateParticle particle)
    {
        for (int i = 0; i < particles.size(); i++)
        {
            if (particles.get(i).isInstance(particle))
            {
                return icons.get(particles.get(i));
            }
        }
        return null;
    }

    public static void registerEntities()
    {

        for (int i = 0; i < particles.size(); i++)
        {
            try
            {
                EntityRegistry.registerModEntity(particles.get(i), particles.get(i).getName(), i, ModParticlePhysics.INSTANCE, 80, 1, true);

            }
            catch (SecurityException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
