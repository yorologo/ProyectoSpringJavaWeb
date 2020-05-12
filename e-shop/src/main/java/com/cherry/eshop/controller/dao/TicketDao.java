package com.cherry.eshop.controller.dao;

import com.cherry.eshop.model.Ticket;
import com.cherry.eshop.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
//import java.util.Locale;
//import java.text.SimpleDateFormat;

/**
 * Returns the Database Access Object (DAO) for our Ticket class.
 */
public class TicketDao {

	/*
	 * Returns one Ticket object or null if not found
	 */
	public Ticket getByID(Integer id) {
		Ticket ticket = null;
		// Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			// trans = session.beginTransaction();

			ticket = (Ticket) session.get(Ticket.class, id);

			// trans.commit();
		} catch (HibernateException e) {
			// if (trans != null) { trans.rollback(); }
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ticket;
	}

	/*
	 * Adds a new Ticket object and return the id
	 */
	public int add(Ticket ticket) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		int id = 0;

		try {
			trans = session.beginTransaction();

			id = (int) session.save(ticket);

			trans.commit();
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}

	/*
	 * Updates Ticket object
	 */
	public void update(Ticket ticket) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trans = session.beginTransaction();

			session.update(ticket);

			trans.commit();
		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Deletes one Ticket record
	 */
	public boolean deleteByID(Integer id) {
		boolean deleted = false;
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			trans = session.beginTransaction();

			Ticket ticket = (Ticket) session.get(Ticket.class, id);

			if (ticket != null) {
				session.delete(ticket);
				trans.commit();
				deleted = true;
			}

		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
			deleted = false;
		} finally {
			session.close();
		}
		return deleted;
	}

	/*
	 * Returns a list of Ticket objects
	 */
	public List<Ticket> getAll() {
		List<Ticket> list = new ArrayList<Ticket>();
		// Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			// trans = session.beginTransaction();

			list = session.createQuery("from Ticket").list();

			// trans.commit();
		} catch (HibernateException e) {
			// if (trans != null) { trans.rollback(); }
			e.printStackTrace();
		} finally {
			// session.flush();
			session.close();
		}
		return list;
	}

}